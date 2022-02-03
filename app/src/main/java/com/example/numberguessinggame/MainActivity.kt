package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var textview: TextView
    lateinit var editText: EditText
    lateinit var hint: TextView
    lateinit var button: Button

    var random: Int = nextInt(1,1000)
    var click: Int = 0
    var start: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        hint = findViewById(R.id.textView2)
        button = findViewById(R.id.button)


        button.setOnClickListener{

            if (start == 0) {
                if (editText.text.isNotEmpty()) {

                    val number: Int = editText.text.toString().toInt()
                    click++

                    if (number < random) {

                        hint.text = "Your number is too low ,"
                        editText.text.clear()

                    } else if (number > random) {

                        hint.text = "Your number is too high"
                        editText.text.clear()

                    } else {

                        textview.text = "Congratulation, your number is correct. You use $click time(s)"
                        hint.text = "tab to play again"
                        button.text = "play again"
                        editText.text.clear()
                        start = 1

                    }
                } else {
                    hint.text = "enter number"
                }
            } else {
                reset()
            }

        }

    }

    fun reset() {
        random = nextInt(1,1000)
        textview.text = "Try to guess the number i'm thinking of from 1-1000!"
        editText.text.clear()
        button.text = "Enter"
        hint.text=""
        start = 0
        click = 0

    }
}