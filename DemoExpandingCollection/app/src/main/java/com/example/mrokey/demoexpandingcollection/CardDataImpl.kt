package com.ramotion.expandingcollection.examples.simple

import com.example.mrokey.demoexpandingcollection.R
import com.ramotion.expandingcollection.ECCardData

import java.util.ArrayList
import java.util.Arrays

class CardDataImpl(private val cardTitle: String, private val mainBackgroundResource: Int?, private val headBackgroundResource: Int?, private val listItems: MutableList<String>) : ECCardData<String> {

    override fun getMainBackgroundResource(): Int? {
        return mainBackgroundResource
    }

    override fun getHeadBackgroundResource(): Int? {
        return headBackgroundResource
    }

    override fun getListItems(): MutableList<String> {
        return listItems
    }

    fun getCardTitle() : String {
        return cardTitle
    }

    companion object {

        fun generateExampleData(): List<ECCardData<*>> {
            val list = ArrayList<ECCardData<*>>()
            list.add(CardDataImpl("Card 1", R.drawable.attractions, R.drawable.attractions_head, createItemsList("Card 1")))
            list.add(CardDataImpl("Card 2", R.drawable.city_scape, R.drawable.city_scape_head, createItemsList("Card 2")))
            list.add(CardDataImpl("Card 3", R.drawable.nature, R.drawable.nature_head, createItemsList("Card 3")))
            return list
        }

        private fun createItemsList(cardName: String): MutableList<String> {
            val list = ArrayList<String>()
            list.addAll(Arrays.asList(
                    "$cardName - Item 1",
                    "$cardName - Item 2",
                    "$cardName - Item 3",
                    "$cardName - Item 4",
                    "$cardName - Item 5",
                    "$cardName - Item 6",
                    "$cardName - Item 7"
            ))
            return list
        }
    }

}