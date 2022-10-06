package com.example.whatsappui.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.R
import com.example.whatsappui.modul.UserData

class UserAdapter(val CallsActivity: FragmentActivity?, val userList:ArrayList<UserData>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{



  inner class UserViewHolder(val view:View):RecyclerView.ViewHolder(view){
      var name:TextView
      var mbNum:TextView
      var mMenus:ImageView

      init {
          name = view.findViewById<TextView>(R.id.mTitle)
          mbNum = view.findViewById<TextView>(R.id.mSubTitle)
          mMenus = view.findViewById(R.id.mMenus)
          mMenus.setOnClickListener { insetup(it) }
      }

      private fun insetup(v:View) {
          val position = userList[adapterPosition]
          val menus = PopupMenu(CallsActivity,v)
          menus.inflate(R.menu.show_menu)
          menus.setOnMenuItemClickListener {
              when(it.itemId){

                  R.id.editText->
                  {
                      val v = LayoutInflater.from(CallsActivity).
                      inflate(R.layout.add_item,null)
                      val name = v.findViewById<EditText>(R.id.userName)
                      val number = v.findViewById<EditText>(R.id.userNo)
                              AlertDialog.Builder(CallsActivity)
                                      .setView(v)
                                      .setPositiveButton("Ok"){
                                          dialog,_->
                                          position.userName = "Student :- "+name.text.toString()
                                          position.userMb = "S.T.D:- "+number.text.toString()
                                          notifyDataSetChanged()
                                          Toast.makeText(CallsActivity,"User Information is Edited",Toast.LENGTH_SHORT).show()
                                          dialog.dismiss()

                                      }
                                      .setNegativeButton("Cancel"){
                                          dialog,_->
                                          dialog.dismiss()

                                      }
                                      .create()
                                      .show()

                      true
                  }
                  R.id.delete->{
                      /**set delete*/
                      AlertDialog.Builder(CallsActivity)
                              .setTitle("Delete")
                              .setIcon(R.drawable.ic_warning)
                              .setMessage("Are you sure delete this Information")
                              .setPositiveButton("Yes"){
                                  dialog,_->
                                  userList.removeAt(adapterPosition)
                                  notifyDataSetChanged()
                                  Toast.makeText(CallsActivity,"Deleted this Information",Toast.LENGTH_SHORT).show()
                                  dialog.dismiss()
                              }
                              .setNegativeButton("No"){
                                  dialog,_->
                                  dialog.dismiss()
                              }
                              .create()
                              .show()

                      true
                  }
                  else-> true
              }

          }
          menus.show()
          val popup = PopupMenu::class.java.getDeclaredField("mPopup")
          popup.isAccessible = true
          val menu = popup.get(menus)
          menu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                  .invoke(menu,true)
      }
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.list_item,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val newList = userList[position]
        holder.name.text = newList.userName
        holder.mbNum.text = newList.userMb
    }

    override fun getItemCount(): Int {
      return  userList.size
    }
}