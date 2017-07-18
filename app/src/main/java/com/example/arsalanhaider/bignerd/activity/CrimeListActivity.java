package com.example.arsalanhaider.bignerd.activity;

import android.support.v4.app.Fragment;

import com.example.arsalanhaider.bignerd.fragments.CrimeListFragment;

/**
 * Created by Arsalan Haider on 7/14/2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}// crime list activity
