package com.example.dummy.ui.customView

// CustomButton.kt
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import com.example.dummy.R

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var button: Button

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_button_layout, this, true)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            Toast.makeText(context, "Custom Button Clicked!", Toast.LENGTH_SHORT).show()
        }

    }

    fun setButtonText(text: String) {
        button.text = text
    }

    fun setOnCustomClickListener(listener: OnClickListener) {
        button.setOnClickListener(listener)
    }
}
