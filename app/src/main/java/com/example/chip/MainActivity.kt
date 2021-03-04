package com.example.chip

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dataList = arrayOf("aaaa", "bbbb", "cccc", "aabb", "aacc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val adaptaer = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        list1.adapter = adaptaer
        list1.isTextFilterEnabled = true // 검색필터기능 등
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val item1 = menu?.findItem(R.id.item1)
        val search1 = item1?.actionView as SearchView
        search1.queryHint = "검색어 입력"

        // ActionView 가 접혀지거나 펼쳐졌을 때 반응 할 리스너
        val listener1 = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                textView.text = "접혀졌습니다"
                return true
            }

            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                textView.text = "펼쳐졌습니다"
                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        val listener2 = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                textView.text = "입력 중입니다."
                textView2.text = "입력 중 : $newText"

                list1.setFilterText(newText)

                if (newText?.length == 0) {
                    list1.clearTextFilter()
                }

                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                textView.text = "입력 완료"
                textView2.text = "입력 완료 : $query"
                return true
            }
        }

        search1.setOnQueryTextListener(listener2)

        return true
    }
}