package com.example.texttospeech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() , TextToSpeech.OnInitListener{
    private val message = "ERROR"
 lateinit var etSpeak : EditText
 lateinit var btSpeak : Button
 lateinit var tts : TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSpeak = findViewById(R.id.etSpeak)
        btSpeak = findViewById(R.id.btSpeak)

        btSpeak.isEnabled = false

        tts = TextToSpeech(this,this)
        btSpeak.setOnClickListener{ speakOut()}

    }

    private fun speakOut() {
        val text =etSpeak.text.toString()
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS) {

            val result = tts.setLanguage(Locale.US)
            if(result ==TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {

                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            //toast
            }
            else {
                btSpeak.isEnabled = true
            }
        }
        }
    }

