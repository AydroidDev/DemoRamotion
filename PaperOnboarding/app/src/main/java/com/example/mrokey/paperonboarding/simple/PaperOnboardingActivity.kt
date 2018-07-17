package com.example.mrokey.paperonboarding.simple

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.mrokey.paperonboarding.R
import com.ramotion.paperonboarding.PaperOnboardingEngine
import com.ramotion.paperonboarding.PaperOnboardingPage
import android.widget.Toast

class PaperOnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_main_layout)

        val engine = PaperOnboardingEngine(findViewById<View>(R.id.onboardingRootView), getDataForOnboarding(), applicationContext)

        engine.setOnChangeListener {
            oldElementIndex, newElementIndex ->
            Toast.makeText(applicationContext, "Swiped from $oldElementIndex to $newElementIndex", Toast.LENGTH_SHORT).show()
        }

        engine.setOnRightOutListener {
            // Probably here will be your exit action
            Toast.makeText(applicationContext, "Swiped out right", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDataForOnboarding(): ArrayList<PaperOnboardingPage>? {
        val scr1 = PaperOnboardingPage("Hotels", "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key)
        val scr2 = PaperOnboardingPage("Banks", "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet)
        val scr3 = PaperOnboardingPage("Stores", "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart)

        val elements = ArrayList<PaperOnboardingPage>()
        elements.add(scr1)
        elements.add(scr2)
        elements.add(scr3)
        return elements

    }
}