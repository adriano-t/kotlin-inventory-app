package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel : ViewModel() {

    var shoeName = MutableLiveData("")
    var shoeSize = MutableLiveData<Int>(40)
    var shoeCompany = MutableLiveData("")
    var shoeDescription = MutableLiveData("")
    var shoeImage = MutableLiveData("")

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


        if (shoeSize.value!! <= 0 ||
            shoeCompany.value!!.isEmpty() ||
            shoeName.value!!.isEmpty() ||
            shoeDescription.value!!.isEmpty()
        ) {
            return false;
        }

        _productsList.value?.add(
            Shoe(
                shoeName.value!!,
                shoeSize.value!!,
                shoeCompany.value!!,
                shoeDescription.value!!,
                shoeImage.value!!
            )
        )
        return true
    }

    fun clearProductDetails() {
        shoeName.value = ""
        shoeSize.value = 40
        shoeCompany.value = ""
        shoeDescription.value = ""
        shoeImage.value = ""
    }
}