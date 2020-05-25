package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.security.AccessControlContext

class SinhVienAdapter (var context: Context, var list: ArrayList<SinhVien>) : BaseAdapter() {
    class ViewHolder(v: View) {
        var tv_ten: TextView? = null
        var tv_tuoi: TextView? = null
        init {
            tv_ten = v.findViewById(R.id.tv_name)
            tv_tuoi = v.findViewById(R.id.tv_age)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        var viewHolder: ViewHolder
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.dong_sv, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        var sv: SinhVien = getItem(position) as SinhVien
        viewHolder.tv_ten?.text = sv.name
        viewHolder.tv_tuoi?.text = sv.age.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}