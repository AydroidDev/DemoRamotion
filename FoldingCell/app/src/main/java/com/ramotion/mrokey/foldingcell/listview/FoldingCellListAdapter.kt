package com.ramotion.mrokey.foldingcell.listview

import android.content.Context
import android.widget.TextView
import com.ramotion.foldingcell.FoldingCell
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ArrayAdapter
import com.ramotion.mrokey.foldingcell.R


class FoldingCellListAdapter(context: Context, objects: List<Item>) : ArrayAdapter<Item>(context, 0, objects) {

    private val unfoldedIndexes = HashSet<Int>()
    var defaultRequestBtnClickListener: View.OnClickListener? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // get item for selected view
        val item = getItem(position)
        // if cell is exists - reuse it, if not - create the new one from resource
        var cell = convertView as FoldingCell?
        val viewHolder: ViewHolder
        if (cell == null) {
            viewHolder = ViewHolder()
            val vi = LayoutInflater.from(context)
            cell = vi.inflate(R.layout.cell, parent, false) as FoldingCell?
            // binding view parts to view holder
            viewHolder.price = cell?.findViewById(R.id.title_price)
            viewHolder.time = cell?.findViewById(R.id.title_time_label)
            viewHolder.date = cell?.findViewById(R.id.title_date_label)
            viewHolder.fromAddress = cell?.findViewById(R.id.title_from_address)
            viewHolder.toAddress = cell?.findViewById(R.id.title_to_address)
            viewHolder.requestsCount = cell?.findViewById(R.id.title_requests_count)
            viewHolder.pledgePrice = cell?.findViewById(R.id.title_pledge)
            viewHolder.contentRequestBtn = cell?.findViewById(R.id.content_request_btn)
            cell?.tag = viewHolder
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true)
            } else {
                cell.fold(true)
            }
            viewHolder = cell.tag as ViewHolder
        }

        if (null == item)
            return cell!!

        // bind data from selected element to view through view holder
        viewHolder.price!!.text = item.price
        viewHolder.time!!.text = item.time
        viewHolder.date!!.text = item.date
        viewHolder.fromAddress!!.text = item.fromAddress
        viewHolder.toAddress!!.text = item.toAddress
        viewHolder.requestsCount!!.text = item.requestsCount.toString()
        viewHolder.pledgePrice!!.text = item.pledgePrice

        // set custom btn handler for list item from that item
        if (item.requestBtnClickListener != null) {
            viewHolder.contentRequestBtn!!.setOnClickListener(item.requestBtnClickListener)
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn!!.setOnClickListener(defaultRequestBtnClickListener)
        }

        return cell!!
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

    // View lookup cache
    private class ViewHolder {
        internal var price: TextView? = null
        internal var contentRequestBtn: TextView? = null
        internal var pledgePrice: TextView? = null
        internal var fromAddress: TextView? = null
        internal var toAddress: TextView? = null
        internal var requestsCount: TextView? = null
        internal var date: TextView? = null
        internal var time: TextView? = null
    }
}
