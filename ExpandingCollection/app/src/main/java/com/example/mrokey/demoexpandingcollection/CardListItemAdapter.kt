
import android.content.Context
import android.support.v4.content.ContextCompat
import android.widget.TextView

import com.ramotion.expandingcollection.ECCardContentListItemAdapter

import android.view.*
import com.example.mrokey.demoexpandingcollection.R

class CardListItemAdapter(context: Context, objects: MutableList<String>) :
        ECCardContentListItemAdapter<String>(context, R.layout.list_item, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        var rowView: View? = convertView

        if (rowView == null) {
            val inflater = LayoutInflater.from(context)
            rowView = inflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder()
            viewHolder.itemText = rowView!!.findViewById(R.id.list_item_text) as TextView
            rowView.tag = viewHolder
        } else {
            viewHolder = rowView.tag as ViewHolder
        }

        val item = getItem(position)
        if (item != null)
            viewHolder.itemText?.text = item

        viewHolder.itemText?.setOnClickListener { v ->
            val tapToRemoveText = "Tap again to remove!"
            val view = v as TextView
            if (view.text == tapToRemoveText) {
                v.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.colorPrimary))
                this@CardListItemAdapter.remove(item)
                this@CardListItemAdapter.notifyDataSetChanged()
            } else {
                view.text = tapToRemoveText
                v.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.colorAccent))
            }
        }
        return rowView
    }

    internal class ViewHolder {
        var itemText: TextView? = null
    }

}