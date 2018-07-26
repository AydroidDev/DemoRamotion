package com.example.mrokey.demoexpandingcollection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import com.ramotion.expandingcollection.ECCardData
import com.ramotion.expandingcollection.ECPagerViewAdapter
import com.ramotion.expandingcollection.examples.simple.CardDataImpl
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Gravity
import android.widget.FrameLayout
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.widget.TextView
import CardListItemAdapter
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = CardDataImpl.generateExampleData()

        val ecPagerViewAdapter = object : ECPagerViewAdapter(applicationContext, dataset) {
            override fun instantiateCard(inflaterService: LayoutInflater?, head: ViewGroup?, list: ListView?, data: ECCardData<*>?) {
                // Data object for current card
                val cardData = data as CardDataImpl

                // Set adapter and items to current card content list
                val listItems = cardData.listItems
                val listItemAdapter = CardListItemAdapter(applicationContext, listItems)
                list?.adapter = listItemAdapter
                // Also some visual tuning can be done here
                list?.setBackgroundColor(Color.WHITE)

                // Here we can create elements for head view or inflate layout from xml using inflater service
                val cardTitle = TextView(applicationContext)
                cardTitle.text = cardData.getCardTitle()
                cardTitle.setTextSize(COMPLEX_UNIT_DIP, 20f)
                val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
                layoutParams.gravity = Gravity.CENTER
                head?.addView(cardTitle, layoutParams)

                // Card toggling by click on head element
                head?.setOnClickListener {
                    ec_pager_element.toggle()
                }
            }

        }
        ec_pager_element.setPagerViewAdapter(ecPagerViewAdapter)
        ec_pager_element.setBackgroundSwitcherView(findViewById(R.id.ec_bg_switcher_element))

        ecPagerViewAdapter.notifyDataSetChanged()
    }
}
