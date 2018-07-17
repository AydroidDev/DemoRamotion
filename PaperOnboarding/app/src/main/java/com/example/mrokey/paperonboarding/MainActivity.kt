package com.example.mrokey.paperonboarding

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mrokey.paperonboarding.fragment.FragmentsActivity
import com.example.mrokey.paperonboarding.simple.PaperOnboardingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple.setOnClickListener {
            startActivity(Intent(this, PaperOnboardingActivity::class.java))
        }

        btn_fragment.setOnClickListener {
            startActivity(Intent(this, FragmentsActivity::class.java))
        }
    }
}