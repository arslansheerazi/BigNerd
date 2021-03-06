package com.example.arsalanhaider.bignerd.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.arsalanhaider.bignerd.R;
import com.example.arsalanhaider.bignerd.activity.CrimeActivity;
import com.example.arsalanhaider.bignerd.centralize.CrimeLab;
import com.example.arsalanhaider.bignerd.model.Crime;

import java.util.List;

/**
 * Created by Arsalan Haider on 7/14/2017.
 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mCrimeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_list);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimeList = crimeLab.getCrimes();

        mCrimeAdapter = new CrimeAdapter(crimeList);
        mCrimeRecyclerView.setAdapter(mCrimeAdapter);
    }// update ui

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> mCrimes) {
            this.mCrimes = mCrimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(view);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime =mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        Crime crime;

        public CrimeHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }// crime holder

        public void bindCrime(Crime crime){
            this.crime = crime;
            mTitleTextView.setText(crime.getmTitle());
            mDateTextView.setText(crime.getmDate().toString());
            mSolvedCheckBox.setChecked(crime.ismSloved());
        }// bind crime

        @Override
        public void onClick(View v) {
            //Toast.makeText(getActivity(),crime.getmTitle(),Toast.LENGTH_SHORT).show();
            Intent mIntent = CrimeActivity.newIntent(getActivity(),crime.getmID());
            startActivity(mIntent);
        }
    } // crime holder

}// crime list fragment
