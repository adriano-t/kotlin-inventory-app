package com.udacity.shoestore.screens.productslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ProductsListFragmentBinding

class ProductsList: Fragment() {

    private lateinit var binding: ProductsListFragmentBinding;

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

        return binding.root
    }
}