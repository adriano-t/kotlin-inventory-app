package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    private var currentProduct = Shoe(
        "",
        0,
        "",
        "",
        "",
    )

    private var _productsList = MutableLiveData<MutableList<Shoe>>(mutableListOf(
        Shoe("Air Max", 40, "Nike", "Cool shoes", "image_1"),
        Shoe("Super", 42, "Adidas", "Very very cool shoes", "image_2"),
        Shoe("Air Max", 40, "Nike", "Cool shoes", "image_1"),
        Shoe("Super", 42, "Adidas", "Very very cool shoes", "image_2"),
    ))
    val productsList: LiveData<MutableList<Shoe>>
        get() = _productsList


    fun setProductSize(view: View, size: Int) {
        currentProduct.size = size
    }

    fun setProductPicture() {
        //currentProduct.image = getRandomPicture()
    }

    private fun saveNewProduct() {
        val newShoe = currentProduct.copy()
        _productsList.value?.add(newShoe)
    }

    fun clearProductDetails() {
        currentProduct = Shoe(
            "",
            0,
            "",
            "",
            "",
        )
    }
}