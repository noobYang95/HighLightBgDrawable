package com.noobyang.highlightbgdrawable

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * 在指定位置挖洞的背景图片
 * 用于新手引导某位置高亮
 *
 * @param circleCenterX 高亮中心X坐标
 * @param circleCenterY 高亮重心Y坐标
 * @param radius 高亮圆圈半径
 *
 * @author noobYang
 */
class HighLightBgDrawable(
    private var circleCenterX: Float,
    private var circleCenterY: Float,
    private var radius: Float
) : Drawable() {

    private val paint = Paint()

    var bgColor: Int = Color.parseColor("#b2000000")

    init {
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
    }

    override fun draw(canvas: Canvas) {

        val saveCount =
            canvas.saveLayer(0f, 0f, bounds.width().toFloat(), bounds.height().toFloat(), paint)

        canvas.drawColor(bgColor)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

        canvas.drawCircle(circleCenterX, circleCenterY, radius, paint)

        paint.xfermode = null

        canvas.restoreToCount(saveCount)

    }

    override fun setAlpha(alpha: Int) {

    }

    override fun setColorFilter(colorFilter: ColorFilter?) {

    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }

    fun update(x: Float, y: Float, radius: Float? = null) {
        circleCenterX = x
        circleCenterY = y
        radius?.let {
            this.radius = it
        }
        invalidateSelf()
    }
}