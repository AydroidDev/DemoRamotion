package com.ramotion.mrokey.foldingcell.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ramotion.mrokey.foldingcell.R
import com.ramotion.mrokey.foldingcell.listview.Item
import kotlinx.android.synthetic.main.cell_content_layout.view.*
import kotlinx.android.synthetic.main.cell_title_layout.view.*

class FoldingCellAdapter(private var items: List<Item>, private val context: Context) : RecyclerView.Adapter<FoldingCellAdapter.ViewHolder>() {

    private val unfoldedIndexes = HashSet<Int>()
    var defaultRequestBtnClickListener: View.OnClickListener? = null
    var itemClickListener : IItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =  items[position]

        holder.price.text = item.price
        holder.time.text = item.time
        holder.date.text = item.date
        holder.fromAddress.text = item.fromAddress
        holder.toAddress.text = item.toAddress
        holder.requestsCount.text = item.requestsCount.toString()
        holder.pledgePrice.text = item.pledgePrice

        // set custom btn handler for list item from that item
        if (item.requestBtnClickListener != null) {
            holder.contentRequestBtn.setOnClickListener(item.requestBtnClickListener)
        } else {
            // (optionally) add "default" handler if no handler found in item
            holder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener)
        }
    }

    // simple methods for register cell state changes
    fun registerToggle(position: Int) {
        if (unfoldedIndexes.contains(position))
            registerFold(position)
        else
            registerUnfold(position)
    }

    private fun registerFold(position: Int) {
        unfoldedIndexes.remove(position)
    }

    private fun registerUnfold(position: Int) {
        unfoldedIndexes.add(position)
    }

    fun setData(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(itemClickListener: IItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val price = view.title_price as TextView
        val contentRequestBtn = view.content_request_btn as TextView
        val pledgePrice = view.title_pledge as TextView
        val fromAddress = view.title_from_address as TextView
        val toAddress = view.title_to_address as TextView
        val requestsCount = view.title_requests_count as TextView
        val date = view.title_date_label as TextView
        val time = view.title_time_label as TextView

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            itemClickListener?.onClickItem(view, adapterPosition)
        }
    }
}