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

    private lateinit var currentText: String

    private var unit: String = ""

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

    /**
     * Unit (won, p, cm etc)
     */
    fun setUnit(unit: String) {
        this.unit = unit
    }

    /**
     * 텍스트 표시
     */
    fun setText(max: Int? = 1000, current: Int? = 700) {

        tvMinText.text = 0.toString()
        tvMidText.text = (max!! / 2).toString()
        tvMaxText.text = max.toString()

        currentText = current.toString()
        tvCurrentText.text = current.toString()

        setValue(max, current!!)
    }

    /**
     * dot, triangle, seekBar 의 drawable 파일 변경
     */
    fun setViewBackground(
            resMainBar: Int? = null,
            resSecondBar: Int? = null,
            resDot: Int? = null,
            resMarkerDown: Int? = null,
            resTitle: Int? = null
    ) {
        if (resMainBar != null) vSeekBarBase.setBackgroundResource(resMainBar)
        if (resSecondBar != null) vSeekBarSecond.setBackgroundResource(resSecondBar)

        if (resDot != null) vSeekBarDot.setBackgroundResource(resDot)
        if (resMarkerDown != null) vSeekBarTriangle.setBackgroundResource(resMarkerDown)

        if (resTitle != null) tvCurrentText.setBackgroundResource(resTitle)
    }

    /**
     * Seekbar 계산해서 닷 위치 갱신하기
     */
    private fun setValue(maxVal: Int, current: Int) {

        val lp = vSeekBarDot.layoutParams as LayoutParams

        when {
            //최저 미만
            current < 0 -> {
                tvCurrentText.setBackgroundResource(R.drawable.bg_round_04_text_purple)
                vSeekBarTriangle.setBackgroundResource(R.drawable.bg_triangle_purple)
                vSeekBarDot.setBackgroundResource(R.drawable.bg_dot_purple)
                lp.horizontalBias = 0.07f
                vSeekBarDot.layoutParams = lp
            }
            //최고 초과
            maxVal < current -> {
                tvCurrentText.setBackgroundResource(R.drawable.bg_round_04_text_purple)
                vSeekBarTriangle.setBackgroundResource(R.drawable.bg_triangle_purple)
                vSeekBarDot.setBackgroundResource(R.drawable.bg_dot_purple)
                lp.horizontalBias = 0.93f
                vSeekBarDot.layoutParams = lp
            }
            else -> {
                tvCurrentText.setBackgroundResource(R.drawable.bg_round_04_text_purple)
                vSeekBarTriangle.setBackgroundResource(R.drawable.bg_triangle_purple)
                vSeekBarDot.setBackgroundResource(R.drawable.bg_dot_purple)

                val sum: Float = when {
                    maxVal - 0 == 0 -> 0.00f
                    else -> (current * 1.00f / maxVal * 1.00f)
                }

                lp.horizontalBias = sum
                vSeekBarDot.layoutParams = lp

                val secondBarLayoutParams = vSeekBarSecond.layoutParams as LayoutParams
                secondBarLayoutParams.endToEnd = vSeekBarDot.id

                /*
                val markerLayoutParams = marker.layoutParams as LayoutParams

                val p = sum * 100
                if (p >= 94f && p < 95f) {
                    markerLayoutParams.horizontalBias = 0.575f
                    marker.layoutParams = markerLayoutParams
                }
                if (p >= 95f && p < 96f) {
                    markerLayoutParams.horizontalBias = 0.625f
                    marker.layoutParams = markerLayoutParams
                }
                if (p >= 96f && p < 97f) {
                    markerLayoutParams.horizontalBias = 0.675f
                    marker.layoutParams = markerLayoutParams
                }
                if (p >= 97f && p < 98f) {
                    markerLayoutParams.horizontalBias = 0.725f
                    marker.layoutParams = markerLayoutParams
                }
                if (p >= 98f && p < 99f) {
                    markerLayoutParams.horizontalBias = 0.775f
                    marker.layoutParams = markerLayoutParams
                }
                if (p in 99f..100f) {
                    markerLayoutParams.horizontalBias = 0.825f
                    marker.layoutParams = markerLayoutParams
                }*/
            }
        }
    }
}