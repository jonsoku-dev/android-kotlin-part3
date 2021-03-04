package com.example.chip

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_actionbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ActionBar 를 커스터마이징 하기 위해서는 기존 ActionBar 를 사라지게 해야한다.
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // layout 을 통해 View 를 생성한다.
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = topBar

        topBar.run {
            textView2.text = "커스텀 액션 바"
            textView2.setTextColor(Color.WHITE)

            button.setOnClickListener {
                textView.text = "액션바의 버튼을 눌렀습니다."
            }
        }
    }
}