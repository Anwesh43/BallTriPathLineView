package com.anwesh.uiprojects.linkedballtripathlineview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.balltripathlineview.BallTriPathLineView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BallTriPathLineView.create(this)
    }
}
