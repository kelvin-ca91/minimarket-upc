package com.example.minimarket.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.example.minimarket.R
import com.example.minimarket.ui.adapters.ProductAdapter

// Función de extensión para cargar imágenes en ImageView utilizando Picasso
fun ImageView.loadImage(url: String?, placeholder: Int = R.drawable.placeholder_image, error: Int = R.drawable.error_image) {
    Picasso.get()
        .load(url) // URL de la imagen
        .placeholder(placeholder) // Imagen mientras carga
        .error(error) // Imagen si ocurre un error
        .into(this) // Cargar la imagen en el ImageView
}
