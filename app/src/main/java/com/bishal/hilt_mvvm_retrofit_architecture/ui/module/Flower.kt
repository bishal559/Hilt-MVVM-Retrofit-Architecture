package com.bishal.hilt_mvvm_retrofit_architecture.ui.module

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flower(
    var category: String? = "",

    var price: Double? = null,

    var instructions: String? = "",

    var photo: String? = null,

    var name: String? = null,

    var productId: Int? = null
) : Parcelable
