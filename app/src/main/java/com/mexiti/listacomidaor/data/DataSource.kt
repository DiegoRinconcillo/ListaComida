package com.mexiti.listacomidaor.data

import com.mexiti.listacomidaor.R
import com.mexiti.listacomidaor.model.Platillo

class DataSource() {
    fun LoadPlatillos(): List<Platillo>{
        return listOf(
            Platillo(R.string.desayuno, R.string.desayuno_precio ,R.string.desayuno_promo , R.drawable.desayuno,),
            Platillo(R.string.hamburger , R.string.hamburger_precio ,R.string.hamburger_promo ,R.drawable.hamburger,),
            Platillo(R.string.pizza , R.string.pizza_precio ,R.string.pizza_promo ,R.drawable.pizza,),
            Platillo(R.string.postre ,R.string.postre_precio ,R.string.postre_promo , R.drawable.postre,),
            Platillo(R.string.pozole , R.string.pozole_precio ,R.string.pozole_promo ,R.drawable.pozole,),
            Platillo(R.string.tacos ,R.string.tacos_precio , R.string.tacos_promo ,R.drawable.tacos, ),
        )
    }
}