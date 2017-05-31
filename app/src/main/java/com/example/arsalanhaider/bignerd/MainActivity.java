package com.example.arsalanhaider.bignerd;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    private String className = getLocalClassName();
    TextView tvFirst, tvSecond, tvThird, tvFourth, tvFifth, tvAnswer;
    RadioGroup radioGroupSelection;

    int[] values = new int[]{1, 2, 3, 4, 5};

    private boolean increment = true;
    private boolean decrement = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        viewListeners();
    }

    private void initView() {

        tvFirst = (TextView) findViewById(R.id.tv_one);
        tvSecond = (TextView) findViewById(R.id.tv_two);
        tvThird = (TextView) findViewById(R.id.tv_three);
        tvFourth = (TextView) findViewById(R.id.tv_four);
        tvFifth = (TextView) findViewById(R.id.tv_five);
        tvAnswer = (TextView) findViewById(R.id.tv_answer);

        radioGroupSelection = (RadioGroup) findViewById(R.id.radio);
    }

    private void viewListeners() {
        tvFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (increment) {
                    generateIncrementValue(1);
                } else {
                    generateDecrementtValue(1);
                }

            }
        });

        tvSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (increment) {
                    generateIncrementValue(2);
                } else {
                    generateDecrementtValue(2);
                }
            }
        });

        tvThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (increment) {
                    generateIncrementValue(3);
                } else {
                    generateDecrementtValue(3);
                }
            }
        });

        tvFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (increment) {
                    generateIncrementValue(4);
                } else {
                    generateDecrementtValue(4);
                }
            }
        });

        tvFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (increment) {
                    generateIncrementValue(5);
                } else {
                    generateDecrementtValue(5);
                }
            }
        });

        tvAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAnswer.setText("?");
            }
        });

        radioGroupSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radio_increment) {
                    increment = true;
                    decrement = false;
                } else {
                    increment = false;
                    decrement = true;
                }
            }
        });
    }

    private void generateIncrementValue(int number) {

        try {
            int answer = values[((number) % values.length)];
            tvAnswer.setText("" + answer);
            tvAnswer.setVisibility(View.INVISIBLE);

            tvAnswer.animate().alpha(1.0f);
            tvAnswer.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Utils.logMessage("MainActivity", e.getMessage());
        }

    }

    private void generateDecrementtValue(int number) {

        try {
//            int answer = values[((number) % values.length)];
//            tvAnswer.setText("" + answer);
            Toast.makeText(MainActivity.this, "Decrement", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Utils.logMessage("MainActivity", e.getMessage());
        }

    }
}
