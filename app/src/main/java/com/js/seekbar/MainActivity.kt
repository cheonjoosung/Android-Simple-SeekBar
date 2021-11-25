package com.js.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.js.simple_seekbar.SimpleSeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<SimpleSeekBar>(R.id.simple_seek_bar)

        val button:Button = findViewById(R.id.btn)
        button.setOnClickListener {
            text.setText("집에가지마 베이비")
        }
    }
}