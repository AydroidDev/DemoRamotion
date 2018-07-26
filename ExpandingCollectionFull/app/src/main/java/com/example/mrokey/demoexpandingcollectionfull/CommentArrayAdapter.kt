package com.example.mrokey.demoexpandingcollectionfull

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.view.LayoutInflater
import android.view.ViewGroup
import android.support.annotation.NonNull
import android.view.View
import android.widget.ImageView
import com.ramotion.expandingcollection.ECCardContentListItemAdapter


class CommentArrayAdapter(context: Context, objects: MutableList<Comment>)
    : ECCardContentListItemAdapter<Comment>(context, R.layout.list_element, objects) {

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        var rowView: View? = convertView

        if (rowView == null) {
            val inflater = LayoutInflater.from(context)

            rowView = inflater.inflate(R.layout.list_element, null)
            // configure view holder
            viewHolder = ViewHolder()
            viewHolder.date = rowView!!.findViewById(R.id.firstLineDate)
            viewHolder.line1 = rowView!!.findViewById(R.id.firstLine)
            viewHolder.line2 = rowView!!.findViewById(R.id.secondLine)
            viewHolder.icon = rowView!!.findViewById(R.id.icon) as ImageView
            rowView.tag = viewHolder
        } else {
            viewHolder = rowView.tag as ViewHolder
        }

        val objectItem = getItem(position)
        if (objectItem != null) {
            viewHolder.line1!!.text = objectItem.commentPersonName!! + ":"
            viewHolder.line2!!.text = objectItem.commentText
            viewHolder.date!!.text = objectItem.commentDate
            viewHolder.icon!!.setImageResource(objectItem.commentPersonPictureRes!!)
        }

        // Removing item by tap on comment icon
        //        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                CommentArrayAdapter.this.remove(objectItem);
        //                CommentArrayAdapter.this.notifyDataSetChanged();
        //            }
        //        });

        return rowView!!
    }

    internal class ViewHolder {
        var date: TextView? = null
        var line1: TextView? = null
        var line2: TextView? = null
        var icon: ImageView? = null
    }

}