package com.example.whatsappui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdpter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return  3

    }

    override fun getItem(position: Int): Fragment {
        var f1 = when(position)
        {
            0->ChatFragment()
            1->StatusActivity()
            2->CallsActivity()
            else
                ->CallsActivity()
        }
       return  f1
    }
}