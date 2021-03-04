package com.example.chip

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("aaaa", "bbbb", "cccc", "aabb", "ccdd")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        list1.adapter = adapter

        // 검색어 기준으로 필터링 될수 있도록 설정한다.
        list1.isTextFilterEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // SearchView 를 가지고 있는 메뉴 아이템 객체에서 SearchView 를 추출한다.
        val item1 = menu?.findItem(R.id.item1)

        // SearchView 객체를 가지고 온다.
        val search1 = item1?.actionView as SearchView

        // 안내 문구를 설정한다.
        search1.queryHint = "검색어 입력"

        // 메뉴 아이템에 배치된 뷰가 접히거나 펼쳐질 때 반응하는 리스너
        val listener1 = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                textView.text = "접혀졌습니다."
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                textView.text = "펼쳐졌습니다."
                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        // SearchView 의 리스너
        val listener2 = object : SearchView.OnQueryTextListener {
            // SearchView 에 문자열을 입력할 때 마다 호출되는 메서드
            override fun onQueryTextChange(newText: String?): Boolean {
                textView.text = "문자열 입력중"
                textView2.text = "입력중 : $newText"

                // SearchView 에 입력한 내용을 listView의 필터 문자열로 설정한다.
                list1.setFilterText(newText)

                // 만약 설정한 문자열의 길이가 0이라면 필터 문자열을 제거한다.
                if (newText?.length == 0) {
                    list1.clearTextFilter()
                }

                return true
            }

            // 키보드의 돋보기 버튼을 눌렀을 때 호출되는 메서드
            override fun onQueryTextSubmit(query: String?): Boolean {
                textView.text = "문자열 입력 완료"
                textView2.text = "입력완료 : $query"
                search1.clearFocus()
                return true
            }
        }

        search1.setOnQueryTextListener(listener2)

        return true
    }
}