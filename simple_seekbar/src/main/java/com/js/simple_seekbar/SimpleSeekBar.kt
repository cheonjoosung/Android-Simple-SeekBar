package com.js.simple_seekbar

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SimpleSeekBar : ConstraintLayout {

    private var tvTitle: TextView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inflate(context, R.layout.layout_simple_seek_bar, this)

        tvTitle = findViewById(R.id.tv_title)
    }

    fun setText(text: String) {
        tvTitle.text = text
    }
}