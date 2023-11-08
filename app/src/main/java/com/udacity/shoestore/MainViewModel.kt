package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    public var currentProduct = MutableLiveData(
        Shoe(
            "",
            0,
            "",
            "",
            "",
        )
    )

    private var _productsList = MutableLiveData<MutableList<Shoe>>(mutableListOf(
        Shoe("Air Max", 40, "Nike", "Cool shoes", "image_1"),
        Shoe("Super", 42, "Adidas", "Very very cool shoes", "image_2"),
        Shoe("Air Max", 40, "Nike", "Cool shoes", "image_1"),
        Shoe("Super", 42, "Adidas", "Very very cool shoes", "image_2"),
    ))
    val productsList: LiveData<MutableList<Shoe>>
        get() = _productsList

    fun setProductPicture() {
        //currentProduct.image = getRandomPicture()
    }

    fun saveNewProduct(): Boolean {
        if(currentProduct.value == null)
            return false

        val shoe = currentProduct.value!!

        if (shoe.size <= 0 ||
            shoe.company.isEmpty() ||
            shoe.name.isEmpty() ||
            shoe.description.isEmpty()
        ) {
            return false;
        }

        _productsList.value?.add(shoe.copy())
        return true
    }

    fun clearProductDetails() {
        currentProduct.value = Shoe(
            "",
            0,
            "",
            "",
            "",
        )
    }
}