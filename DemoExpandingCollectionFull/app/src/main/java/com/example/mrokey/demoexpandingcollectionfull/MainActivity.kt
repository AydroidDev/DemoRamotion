package com.example.mrokey.demoexpandingcollectionfull

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.R.id.toggle
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import com.ramotion.expandingcollection.ECCardData
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.ramotion.expandingcollection.ECPagerView
import com.ramotion.expandingcollection.ECPagerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create adapter for pager
        val adapter = object : ECPagerViewAdapter(this, ExampleDataset().getDataset()) {
            @SuppressLint("SetTextI18n")
            override fun instantiateCard(inflaterService: LayoutInflater, head: ViewGroup, list: ListView, data: ECCardData<*>) {
                val cardData = data as CardData

                // Create adapter for list inside a card and set adapter to card content
                val commentArrayAdapter = CommentArrayAdapter(applicationContext, cardData.listItems!!)
                list.adapter = commentArrayAdapter
                list.divider = resources.getDrawable(R.drawable.list_divider)
                list.dividerHeight = pxFromDp(applicationContext, 0.5f).toInt()
                list.setSelector(R.color.transparent)
                list.setBackgroundColor(Color.WHITE)
                list.cacheColorHint = Color.TRANSPARENT

                // Add gradient to root header view
                val gradient = View(applicationContext)
                gradient.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT)
                gradient.setBackgroundDrawable(resources.getDrawable(R.drawable.card_head_gradient))
                head.addView(gradient)

                // Inflate main header layout and attach it to header root view
                inflaterService.inflate(R.layout.simple_head, head)

                // Set header data from data object
                val title = head.findViewById<View>(R.id.title) as TextView
                title.text = cardData.headTitle
                val avatar = head.findViewById<View>(R.id.avatar) as ImageView
                avatar.setImageResource(cardData.personPictureResource!!)
                val name = head.findViewById<View>(R.id.name) as TextView
                name.text = cardData.personName!! + ":"
                val message = head.findViewById<View>(R.id.message) as TextView
                message.text = cardData.personMessage
                val viewsCount = head.findViewById<View>(R.id.socialViewsCount) as TextView
                viewsCount.text = " " + cardData.personViewsCount
                val likesCount = head.findViewById<View>(R.id.socialLikesCount) as TextView
                likesCount.text = " " + cardData.personLikesCount
                val commentsCount = head.findViewById<View>(R.id.socialCommentsCount) as TextView
                commentsCount.text = " " + cardData.personCommentsCount

                // Add onclick listener to card header for toggle card state
                head.setOnClickListener { ec_pager_element.toggle() }
            }
        }
        ec_pager_element.setPagerViewAdapter(adapter)
        ec_pager_element.setBackgroundSwitcherView(findViewById(R.id.ec_bg_switcher_element))

        ec_pager_element.setOnCardSelectedListener {
            newPosition, oldPosition, totalElements -> items_count_view.update(newPosition, oldPosition, totalElements)
        }

    }

    fun dpFromPx(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }
}
