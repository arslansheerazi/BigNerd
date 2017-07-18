package com.example.arsalanhaider.bignerd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ToggleButton;

public class ToogleButtonActivity extends AppCompatActivity {

    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curve_bar_layout);

        toggleButton = (ToggleButton) findViewById(R.id.toggle);
//        AnimationDrawable backgroundDrawable = (AnimationDrawable)toggleButton.getBackground().getCurrent();
//        backgroundDrawable.start();
    }
}
