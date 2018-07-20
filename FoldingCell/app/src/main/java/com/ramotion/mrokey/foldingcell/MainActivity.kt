package com.ramotion.mrokey.foldingcell

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ramotion.mrokey.foldingcell.listview.ListViewActivity
import com.ramotion.mrokey.foldingcell.recyclerview.RecyclerViewActivity
import com.ramotion.mrokey.foldingcell.simple.SimpleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simple.setOnClickListener {
            startActivity(Intent(this, SimpleActivity::class.java))
        }

        list_view.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        recycler_view.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }

}