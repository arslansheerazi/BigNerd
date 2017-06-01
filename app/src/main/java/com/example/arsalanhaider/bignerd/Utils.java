package com.example.arsalanhaider.bignerd;

import android.util.Log;

/**
 * Created by Arsalan Haider on 5/18/2017.
 */

public class Utils {

    public static void logMessage(String classTag , String logMessage){
        Log.d("*****"+classTag+"*****" , "<>"+logMessage+"<>");
    }

    public static boolean isEmpty(String value){

        return value == null || value.isEmpty();
    }
}
