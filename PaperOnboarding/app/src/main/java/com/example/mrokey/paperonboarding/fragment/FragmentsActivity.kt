package com.example.mrokey.paperonboarding.fragment

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import android.graphics.Color
import com.example.mrokey.paperonboarding.R
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener


class FragmentsActivity : AppCompatActivity() {

    var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragments_activity_layout)

        fragmentManager = supportFragmentManager

        val onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding())

        val fragmentTransaction = fragmentManager?.beginTransaction()

        fragmentTransaction?.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction?.commit()

        onBoardingFragment.setOnRightOutListener {
            PaperOnboardingOnRightOutListener {
                val fragmentTransaction = fragmentManager?.beginTransaction()
                val bf = BlankFragment()
                fragmentTransaction?.replace(R.id.fragment_container, bf)
                fragmentTransaction?.commit()
            }
        }

    }

    private fun getDataForOnboarding(): ArrayList<PaperOnboardingPage> {
        // prepare data
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
