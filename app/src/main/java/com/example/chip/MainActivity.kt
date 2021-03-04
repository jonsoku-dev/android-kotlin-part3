package com.example.chip

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        toolbar_layout.setCollapsedTitleTextColor(Color.WHITE)
        toolbar_layout.setExpandedTitleColor(Color.GREEN)

        toolbar_layout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
        toolbar_layout.expandedTitleGravity = Gravity.RIGHT + Gravity.TOP

        imageView.setImageResource(R.drawable.imgflag8)

        supportActionBar?.title = "title!"
    }
}