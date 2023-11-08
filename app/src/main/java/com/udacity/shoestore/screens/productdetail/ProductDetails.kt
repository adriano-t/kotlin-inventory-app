package com.udacity.shoestore.screens.productdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ProductDetailFragmentBinding
import timber.log.Timber

class ProductDetails: Fragment(){
    private lateinit var binding: ProductDetailFragmentBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.product_detail_fragment,
            container,
            false
        )

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this

        binding.buttonProductSave.setOnClickListener {
            if (viewModel.saveNewProduct()) {
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
                viewModel.clearProductDetails()
                findNavController().navigateUp()
                Timber.i("Saved")
            } else {
                Toast.makeText(context, "Fill the form to save the product", Toast.LENGTH_SHORT).show()
                Timber.i("Not saved")
            }
        }

        binding.buttonProductCancel.setOnClickListener {
            viewModel.clearProductDetails()
            findNavController().navigateUp()
        }

        return binding.root
    }

}