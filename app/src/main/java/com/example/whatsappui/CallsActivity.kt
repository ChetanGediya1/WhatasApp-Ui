package com.example.whatsappui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.modul.UserData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.whatsappui.view.UserAdapter

class CallsActivity : Fragment() {
    lateinit var addsBtn: FloatingActionButton
    lateinit var recv: RecyclerView
    lateinit var userList: ArrayList<UserData>
    lateinit var userAdapter: UserAdapter
    lateinit var   btnSearch :Button
    lateinit var edtSearch :EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_calls_activity, container, false)

        userList = ArrayList()
        addsBtn = view.findViewById(R.id.addingBtn)
        recv = view.findViewById(R.id.mRecycler)
        userAdapter = UserAdapter(activity, userList)
        recv.layoutManager = LinearLayoutManager(activity)
//        btnSearch = view.findViewById(R.id.btnSearch)
//        edtSearch = view.findViewById(R.id.edtSearch)
        recv.adapter = userAdapter
        addsBtn.setOnClickListener {
            addInfo()
        }
        return view


    }

    private fun addInfo() {
        var inflter = LayoutInflater.from(activity)
        val v = inflter.inflate(R.layout.add_item,null)

        val userName = v.findViewById<EditText>(R.id.userName)
        val userNo = v.findViewById<EditText>(R.id.userNo)

        val addDialog = AlertDialog.Builder(requireActivity())



        addDialog.setView(v)
        addDialog.setPositiveButton("Ok") { dialog, _ ->
            val names = userName.text.toString()
            val number = userNo.text.toString()
            userList.add(UserData("Student :- $names", "S.T.D:- $number"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(activity, "Adding User Information Success", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel")
        { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(activity, "Cancel", Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }


}
