package com.example.whatsappui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.whatsappui.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CHATS"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("STATUS"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("CALLS"))

        var viewAdpter = TabAdpter(supportFragmentManager)
        binding.viewScreenPager.adapter = viewAdpter

        binding.viewScreenPager.setOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(
                binding.tabLayout
            )
        )
        binding.tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewScreenPager.currentItem=tab!!.position


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dialog,menu)
return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.a->
                Toast.makeText(this,"New group",Toast.LENGTH_SHORT).show()
            R.id.b->
                Toast.makeText(this,"New brodcast",Toast.LENGTH_SHORT).show()
            R.id.c->
                Toast.makeText(this,"Linked devices",Toast.LENGTH_SHORT).show()
            R.id.d->
                Toast.makeText(this,"Starred messages",Toast.LENGTH_SHORT).show()
            R.id.e->
                Toast.makeText(this,"Payments",Toast.LENGTH_SHORT).show()
            R.id.f->
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }



}