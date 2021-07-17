package com.noobyang.highlightbgdrawabledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.noobyang.highlightbgdrawable.HighLightBgDrawable

class MainActivity : AppCompatActivity() {

    private val highLightBg: HighLightBgDrawable by lazy {
        HighLightBgDrawable(300f, 300f, 100f)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FrameLayout>(R.id.fl_test).apply {
            background = highLightBg
            setOnClickListener {
                highLightBg.update(
                    getRandom(1080, 0),
                    getRandom(1920, 0),
                    getRandom(500, 100)
                )
            }
        }
    }

    private fun getRandom(max: Int, min: Int): Float {
        return (System.currentTimeMillis() % (max - min) + min).toFloat()
    }
}