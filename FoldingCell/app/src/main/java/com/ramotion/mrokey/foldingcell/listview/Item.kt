package com.ramotion.mrokey.foldingcell.listview

import android.view.View

class Item(price: String, pledgePrice: String, fromAddress: String, toAddress: String, var requestsCount: Int, date: String, time: String) {

    var price: String? = price
    var pledgePrice: String? = pledgePrice
    var fromAddress: String? = fromAddress
    var toAddress: String? = toAddress
    var date: String? = date
    var time: String? = time

    var requestBtnClickListener: View.OnClickListener? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val item = other as Item?

        if (requestsCount != item!!.requestsCount) return false
        if (if (price != null) price != item.price else item.price != null) return false
        if (if (pledgePrice != null) pledgePrice != item.pledgePrice else item.pledgePrice != null)
            return false
        if (if (fromAddress != null) fromAddress != item.fromAddress else item.fromAddress != null)
            return false
        if (if (toAddress != null) toAddress != item.toAddress else item.toAddress != null)
            return false
        return if (if (date != null) date != item.date else item.date != null) false else !if (time != null) time != item.time else item.time != null

    }

    override fun hashCode(): Int {
        var result = if (price != null) price!!.hashCode() else 0
        result = 31 * result + if (pledgePrice != null) pledgePrice!!.hashCode() else 0
        result = 31 * result + if (fromAddress != null) fromAddress!!.hashCode() else 0
        result = 31 * result + if (toAddress != null) toAddress!!.hashCode() else 0
        result = 31 * result + requestsCount
        result = 31 * result + if (date != null) date!!.hashCode() else 0
        result = 31 * result + if (time != null) time!!.hashCode() else 0
        return result
    }

    companion object {

        /**
         * @return List of elements prepared for tests
         */
        val testingList: ArrayList<Item>
            get() {
                val items = ArrayList<Item>()
                items.add(Item("$14", "$270", "W 79th St, NY, 10024", "W 139th St, NY, 10030", 3, "TODAY", "05:10 PM"))
                items.add(Item("$23", "$116", "W 36th St, NY, 10015", "W 114th St, NY, 10037", 10, "TODAY", "11:10 AM"))
                items.add(Item("$63", "$350", "W 36th St, NY, 10029", "56th Ave, NY, 10041", 0, "TODAY", "07:11 PM"))
                items.add(Item("$19", "$150", "12th Ave, NY, 10012", "W 57th St, NY, 10048", 8, "TODAY", "4:15 AM"))
                items.add(Item("$5", "$300", "56th Ave, NY, 10041", "W 36th St, NY, 10029", 0, "TODAY", "06:15 PM"))
                return items

            }
    }

}