package com.ramotion.mrokey.foldingcell.recyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ramotion.foldingcell.FoldingCell
import com.ramotion.mrokey.foldingcell.R
import com.ramotion.mrokey.foldingcell.listview.Item
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        mainListView.hasFixedSize()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainListView.layoutManager = layoutManager

        val items = Item.testingList

        items[0].requestBtnClickListener = View.OnClickListener {
            Toast.makeText(this, "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show()
            Log.d("UMHUM", "CUSTOM HANDLER FOR FIRST BUTTON")
        }

        val adapter = FoldingCellAdapter(items, this)

        adapter.defaultRequestBtnClickListener = View.OnClickListener {
            Toast.makeText(this, "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show()
            Log.d("UMHUM", "DEFAULT HANDLER FOR ALL BUTTONS")
        }

        mainListView.adapter = adapter

        adapter.setOnItemClickListener(object : IItemClickListener {
            override fun onClickItem(view: View?, position: Int) {
                (view as FoldingCell).toggle(false)
                adapter.registerToggle(position)
            }

        })
    }
}