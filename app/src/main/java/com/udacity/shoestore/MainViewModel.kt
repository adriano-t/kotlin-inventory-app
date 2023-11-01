package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShareViewModel : ViewModel() {

    private var currentProduct = Shoe(
        "",
        0,
        "",
        "",
        "",
    )

    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList


    fun setProductSize(view: View, size: Int) {
        currentProduct.size = size
    }

    fun setProductPicture() {
        //currentProduct.image = getRandomPicture()
    }

    private fun saveNewProduct() {
        val newShoe = currentProduct.copy()
        _shoesList.value?.add(newShoe)
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