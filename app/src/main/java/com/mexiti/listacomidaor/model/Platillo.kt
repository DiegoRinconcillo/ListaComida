package com.mexiti.listacomidaor.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceIdR: Int,
    @StringRes val stringResourceIdRes: Int,
    @DrawableRes val drawableResourceId: Int,
)
