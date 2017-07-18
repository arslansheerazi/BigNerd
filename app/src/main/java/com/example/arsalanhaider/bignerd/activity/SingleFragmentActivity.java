package com.example.arsalanhaider.bignerd.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.example.arsalanhaider.bignerd.R;

/**
 * Created by Arsalan Haider on 7/14/2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.crime_conatainer);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.crime_conatainer , fragment).commit();
        }
    }// on create


}// single fragment activity
