package com.example.whatsappui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsappui.databinding.FragmentChatBinding
import com.example.whatsappui.modul.StatusModel

class ChatFragment : Fragment() {

    lateinit var bindings: FragmentChatBinding

    var imageStudent = arrayOf(
        R.drawable.st,
        R.drawable.st2,
        R.drawable.st3,
        R.drawable.st4,
        R.drawable.st5,
        R.drawable.st6 ,
        R.drawable.st7,
        R.drawable.st8,
        R.drawable.st9,
        R.drawable.st10,
        R.drawable.st11,
        R.drawable.st12
    )
    var nameStudent = arrayOf(
        "Raj virani",
        "Pranav Vaghani",
        "Ronak Bhut",
        "Harsh Narola",
        "Jay Patel",
        "Raj Dave",
        "Meet Kotadiya",
        "Amit Chohan",
        "Milan Patel",
        "Jayesh Dave",
        "Vinay Joshi",
        "Aryan Patel"
    )
    var StdStudent = arrayOf(
        "S.T.D. = 8",
        "S.T.D. = 9",
        "S.T.D. = 10",
        "S.T.D. = 11",
        "S.T.D. = 12",
        "S.T.D. = 12",
        "S.T.D. = 10",
        "S.T.D. = 11",
        "S.T.D. = 12",
        "S.T.D. = 9",
        "S.T.D. = 10",
        "S.T.D. = 12"
    )
    var Time = arrayOf(
        "05:31 AM",
        "07:45 AM",
        "09:08 AM",
        "11:29 AM",
        "01:30 PM",
        "02:31 PM",
        "04:45 PM",
        "05:08 PM",
        "07:29 PM",
        "09:30 PM",
        "10:31 PM",
        "11:45 PM")


    var list = arrayListOf<StatusModel>()
    var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings =
            FragmentChatBinding.bind(inflater.inflate(R.layout.fragment_chat, container, false))


        while (i < imageStudent.size) {
            val statusModel = StatusModel(imageStudent[i], nameStudent[i], StdStudent[i],Time[i])
            list.add(statusModel)
            i++
        }

        var statusAdpter = StatusAdpter(activity, list)
        var ln = LinearLayoutManager(activity)

        bindings.recycleview.layoutManager = ln
        bindings.recycleview.adapter = statusAdpter

        return bindings.root

    }

}