package com.example.minimarket

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

//    private val backButton: ImageButton
    private val titleTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this, true)
//        backButton = findViewById(R.id.button_back)
        titleTextView = findViewById(R.id.text_title)

//        backButton.setOnClickListener {
            // Maneja el clic del botón atrás
            // Puede ser sobreescrito en la actividad/fragement
//        }
    }

    fun setTitle(title: String) {
        titleTextView.text = title
    }

    fun setOnBackButtonClickListener(listener: OnClickListener) {
//        backButton.setOnClickListener(listener)
    }
}
