package com.example.whatsappui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.modul.StatusModel
import de.hdodenhof.circleimageview.CircleImageView


class StatusAdpter(val chatFragment: FragmentActivity?, val list: ArrayList<StatusModel>) :
    RecyclerView.Adapter<StatusAdpter.viewData>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(chatFragment).inflate(R.layout.item_list, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {
        holder.txtImages.setImageResource(list[position].image)
        holder.txtName.text = list[position].name
        holder . txtSTD.text = list [position].s
        holder.txtTime.text = list[position].time

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtImages = itemView.findViewById<CircleImageView>(R.id.txtImages)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtSTD = itemView.findViewById<TextView>(R.id.txtSTD)
        var txtTime = itemView.findViewById<TextView>(R.id.txtTime)

    }
}