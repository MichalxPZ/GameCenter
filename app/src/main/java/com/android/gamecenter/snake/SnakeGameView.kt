package com.android.gamecenter.snake

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.SurfaceView

class SnakeGameView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SurfaceView(context, attrs, defStyleAttr) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }
}