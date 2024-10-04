package com.example.dummy

import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.example.dummy.ui.customView.CustomButton

class MainActivity : AppCompatActivity(), KeyboardView.OnKeyboardActionListener {
    private lateinit var editText: EditText
    private lateinit var keyboardView: KeyboardView
    private lateinit var customKeyboard: Keyboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<CustomButton>(R.id.custom_button)
        button.setButtonText("Do not click here")


        editText = findViewById(R.id.etInput)
        keyboardView = findViewById(R.id.keyboardView)

        // Initialize the custom keyboard with the XML layout
        customKeyboard = Keyboard(this, R.xml.keyboard_layout)

        // Attach the keyboard to the KeyboardView
        keyboardView.keyboard = customKeyboard
        keyboardView.setOnKeyboardActionListener(this)

        // Show the keyboard (optional: you can adjust this behavior)
        keyboardView.isPreviewEnabled = false
    }

    override fun onPress(primaryCode: Int) {
        Log.d("Keyboard", "Key Pressed: $primaryCode")
    }

    override fun onRelease(primaryCode: Int) {
        Log.d("Keyboard", "Key Pressed: $primaryCode")

    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        when (primaryCode) {
            -2 -> {
                editText.text.clear()
            }
            -3 -> {
                val length = editText.text.length
                if (length > 0) {
                    editText.text.delete(length - 1, length)
                }
            }
            else -> {
                val char = primaryCode.toChar()
                editText.append(char.toString())
            }
        }
    }

    override fun onText(text: CharSequence?) {
        TODO("Not yet implemented")
    }

    override fun swipeLeft() {
        TODO("Not yet implemented")
    }

    override fun swipeRight() {
        TODO("Not yet implemented")
    }

    override fun swipeDown() {
        TODO("Not yet implemented")
    }

    override fun swipeUp() {
        TODO("Not yet implemented")
    }
}