package com.nghom.covideradmin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class SharedPrefs {

    private SharedPreferences sharedPrefs;
    private static Context mContext = null;

    public static SharedPrefs mInstance;

    public SharedPrefs(Context context) {
        SharedPrefs.mContext = context;
        sharedPrefs = context.getSharedPreferences(Constants.sharedPrefName, Context.MODE_PRIVATE);
        mInstance = this;
    }

    public static SharedPrefs getInstance() {
        return mInstance;
    }

    public void clear() {
        sharedPrefs.edit().clear().commit();
    }
}
