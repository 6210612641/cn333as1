package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var textview: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton

    var random: Int = nextInt(1,100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textview.text = "Please enter your guess:"

        imageButtonCheck.setOnClickListener{

            val number: Int = editText.text.toString().toInt()

            if (number < random){

                textview.text = "Wrong, your number is too low"
                editText.text.clear()

            } else if (number > random){

                textview.text = "Wrong, your number is too high"
                editText.text.clear()

            } else {

                textview.text = "Congratulation, your number is correct"
                editText.text.clear()

            }
        }

        imageButtonReset.setOnClickListener{
            reset()
        }
    }

    fun reset() {
        random = nextInt(1,100)
        textview.text = "Please enter your guess:"
        editText.text.clear()

    }
}