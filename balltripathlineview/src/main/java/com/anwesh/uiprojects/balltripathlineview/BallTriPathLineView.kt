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
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#01579B")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

