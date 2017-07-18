package com.example.arsalanhaider.bignerd.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.arsalanhaider.bignerd.R;
import com.example.arsalanhaider.bignerd.model.Crime;

import static com.example.arsalanhaider.bignerd.R.id.crime_solved;

/**
 * Created by Arsalan Haider on 7/11/2017.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText edtCrimeTitle;
    private Button btDate;
    private CheckBox chkSolved;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }//end of on create

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.crime_fragment, container, false);

        edtCrimeTitle = (EditText) v.findViewById(R.id.edt_crime_title);
        btDate = (Button) v.findViewById(R.id.crime_date);
        chkSolved = (CheckBox) v.findViewById(crime_solved);

        btDate.setText(mCrime.getmDate().toString());
        btDate.setEnabled(false);

        chkSolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSloved(isChecked);
            }
        });
        edtCrimeTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setmTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }//end of on create view
}
