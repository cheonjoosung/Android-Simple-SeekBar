package com.js.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.js.simple_seekbar.SimpleSeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = SimpleSeekBar()
        seekBar.test()
    }
}