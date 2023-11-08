package com.udacity.shoestore.screens.productslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ProductsListFragmentBinding
import com.udacity.shoestore.databinding.ProductsListItemBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ProductsList: Fragment() {

    private lateinit var binding: ProductsListFragmentBinding;
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.products_list_fragment,
            container,
            false
        )

        binding.buttonAdd.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                ProductsListDirections.actionProductsListToProductDetails()
            )
        )

        setHasOptionsMenu(true)

        // disable the back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        // binding.viewModel = viewModel

        viewModel.productsList.observe(viewLifecycleOwner) { productsList ->
            inflateProducts(productsList)
        }

        return binding.root
    }

    private fun inflateProducts(products: MutableList<Shoe>) {
        var parent = binding.productsContainer

        for (product in products) {
            Timber.i("product ${product.name}")
            val productItem: ProductsListItemBinding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout.products_list_item,
                parent,
                true,
            )

            productItem.apply {
                labelProductCompany.text = product.company
                labelProductDescription.text = product.description
                labelProductName.text = product.name
                labelProductSize.text = "Size: ${product.size}"

                productImage.setImageResource(viewModel.shoeImages[product.imageIndex])
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_productsList_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }


}