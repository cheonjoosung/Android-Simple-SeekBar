package com.js.simple_seekbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SimpleSeekBar : ConstraintLayout {

    private var vSeekBarBase: View
    private var vSeekBarSecond: View

    private var vSeekBarDot: View
    private var vSeekBarTriangle: View

    private var tvMinText: TextView
    private var tvMidText: TextView
    private var tvMaxText: TextView

    private var tvCurrentText: TextView

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        inflate(context, R.layout.layout_simple_seek_bar, this)

        vSeekBarBase = findViewById(R.id.v_seek_bar_base)
        vSeekBarSecond = findViewById(R.id.v_seek_bar_second)

        vSeekBarDot = findViewById(R.id.v_seek_bar_dot)
        vSeekBarTriangle = findViewById(R.id.v_seek_bar_triangle)

        tvMinText = findViewById(R.id.tv_min_text)
        tvMidText = findViewById(R.id.tv_mid_text)
        tvMaxText = findViewById(R.id.tv_max_text)

        tvCurrentText = findViewById(R.id.tv_current_text)
    }

}