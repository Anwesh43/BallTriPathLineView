package com.anwesh.uiprojects.balltripathlineview

/**
 * Created by anweshmishra on 21/10/19.
 */
import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas

val nodes : Int = 5
val parts : Int = 4
val scGap : Float = 0.01f
val delay : Long = 20
val strokeFactor : Int = 90
val sizeFactor : Float = 4f
val foreColor : Int = Color.parseColor("#01579B")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawBallTriPathLine(i : Int, size : Float, scale : Float, paint : Paint) {
    val r : Float = size / sizeFactor
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    val sc4 : Float = scale.divideScale(3, parts)
    var x1 : Float = 0f
    var x2 : Float = size
    if (i == nodes - 1) {
        x1 = size * sc2
        x2 = size + size * sc4
    }
    var cx : Float = (size / 2) * (sc2 + sc4)
    var cy : Float = (-size / 2) * (sc2 - sc4)
    var ex : Float = (size / 2) * (sc1 + sc3)
    var ey : Float = (-size / 2) * (sc1 - sc3)
    drawCircle(cx, cy, r, paint)
    drawLine(cx, cy, ex, ey, paint)
    drawLine(x1, 0f, x2, 0f, paint)
}

fun Canvas.drawBTPLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    paint.color = foreColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(gap * (i + 1), h / 2)
    drawBallTriPathLine(i, gap, scale, paint)
    restore()
}

class BallTriPathLineView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
