package com.ramotion.mrokey.foldingcell.recyclerview

import android.view.View

interface IItemClickListener {
    fun onClickItem(view : View?, position: Int)
}