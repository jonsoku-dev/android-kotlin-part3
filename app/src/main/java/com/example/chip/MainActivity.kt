package com.example.chip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    val frag1 = SubFragment1()
    val frag2 = SubFragment2()
    val frag3 = SubFragment3()

    val fragList = arrayOf(frag1, frag2, frag3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(toolbar)

        val adapter1 = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragList[position]
            }
        }

        pager2.adapter = adapter1
    }
}