package com.example.mrokey.demoexpandingcollectionfull

import com.ramotion.expandingcollection.ECCardData
import java.util.*


class CardData : ECCardData<Comment> {

    var headTitle: String? = null
    private var headBackgroundResource: Int? = null
    private var mainBackgroundResource: Int? = null

    var personPictureResource: Int? = null
    var personName: String? = null
    var personMessage: String? = null
    var personViewsCount: Int = 0
    var personCommentsCount: Int = 0
    var personLikesCount: Int = 0
    private var listItems: MutableList<Comment>? = null

    init {
        val rnd = Random()
        this.personViewsCount = 50 + rnd.nextInt(950)
        this.personCommentsCount = 35 + rnd.nextInt(170)
        this.personLikesCount = 10 + rnd.nextInt(1000)
    }

    override fun getHeadBackgroundResource(): Int? {
        return headBackgroundResource
    }

    fun setHeadBackgroundResource(headBackgroundResource: Int?) {
        this.headBackgroundResource = headBackgroundResource
    }

    override fun getMainBackgroundResource(): Int? {
        return mainBackgroundResource
    }

    fun setMainBackgroundResource(mainBackgroundResource: Int?) {
        this.mainBackgroundResource = mainBackgroundResource
    }

    override fun getListItems(): MutableList<Comment>? {
        return listItems
    }

    fun setListItems(listItems: MutableList<Comment>) {
        this.listItems = listItems
    }
}