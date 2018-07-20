package com.ramotion.mrokey.foldingcell.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ramotion.mrokey.foldingcell.R
import kotlinx.android.synthetic.main.activity_simple.*

class SimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        toggle_btn.setOnClickListener {
            folding_cell.toggle(false)
        }

        toggle_instant_btn.setOnClickListener {
            folding_cell.toggle(true)
        }
    }
}