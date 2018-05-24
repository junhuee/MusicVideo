package com.jjunsoft.musicvideo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alfo06-05 on 2018-03-21.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    Fragment[] frags = new Fragment[3];
    String[] title= {"홈","인기","랜덤"};



    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    frags[0] = new page1Fragment();
    frags[1] = new page2Fragment();
    frags[2] = new page3Fragment();


    }



    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
