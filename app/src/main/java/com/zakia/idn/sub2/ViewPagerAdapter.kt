package com.zakia.idn.sub2

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.zakia.idn.sub2.fragment.MovieFragment
import com.zakia.idn.sub2.fragment.TvShowFragment

class ViewPagerAdapter(var context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return MovieFragment()
            1 -> return TvShowFragment()
        }
        return MovieFragment()
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) {
            return context.getString(R.string.tab_text_1)
        } else if (position == 1) {
            return context.getString(R.string.tab_text_2)
        }
        return super.getPageTitle(position)
    }
}