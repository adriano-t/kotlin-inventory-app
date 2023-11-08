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
            -1,
        )
    )

    public val shoeImages = listOf(
        R.drawable.shoe_0,
        R.drawable.shoe_1,
        R.drawable.shoe_2,
        R.drawable.shoe_3,
        R.drawable.shoe_4,
        R.drawable.shoe_5
    )

    private var _productsList = MutableLiveData<MutableList<Shoe>>(mutableListOf(
        Shoe("Air Max", 40, "Nike", "Cool shoes", 0),
        Shoe("Super", 42, "Adidas", "Very very cool shoes", 3),
        Shoe("Speed Z", 40, "Green", "The perfect shoes", 2),
        Shoe("All Stars", 42, "Converse", "Very very cool shoes", 1),
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
            shoe.description.isEmpty() ||
            shoe.imageIndex == -1
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
            -1,
        )
    }
}