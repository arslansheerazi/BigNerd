package com.example.arsalanhaider.bignerd.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Arsalan Haider on 7/10/2017.
 */

public class Crime {

    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSloved;

    public Crime() {
        mID = UUID.randomUUID();
        mDate = new Date();
    }//end of constructor

    public UUID getmID() {
        return mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean ismSloved() {
        return mSloved;
    }

    public void setmSloved(boolean mSloved) {
        this.mSloved = mSloved;
    }
}// end of class crime
