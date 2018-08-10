package com.azens.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.azens.news.ui.BBCFragment;
import com.azens.news.ui.BloombergFragment;
import com.azens.news.ui.TechCrunchFragment;

/**
 * Created by Azens Eklak on 8/10/18.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new TechCrunchFragment();
        }
        else if (position == 1)
        {
            fragment = new BBCFragment();
        }
        else if (position == 2)
        {
            fragment = new BloombergFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "TechCrunch";
        }
        else if (position == 1)
        {
            title = "BBC";
        }
        else if (position == 2)
        {
            title = "Bloomberg";
        }
        return title;
    }
}
