package com.example.arsalanhaider.bignerd.centralize;

import android.content.Context;

import com.example.arsalanhaider.bignerd.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Arsalan Haider on 7/14/2017.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSloved(i % 2 == 0);
            mCrimes.add(crime);
        }// for
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {

        for (Crime crime : mCrimes) {
            if (crime.getmID().equals(id)) {
                return crime;
            }
        }
        return null;

    }
}// crime lab
