package com.example.arsalanhaider.bignerd.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.arsalanhaider.bignerd.fragments.CrimeFragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    public static final String CRIME_EXTRA_ID = "com.example.arsalanhaider.bignerd.activity.CrimeActivity.crime_id";

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Fragment currentFragment;

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    public static Intent newIntent(Context packageContext , UUID crimeId){
        Intent intent = new Intent(packageContext , CrimeActivity.class);
        intent.putExtra("",crimeId);
        return intent;
    }// s new intent
}// crime activity
