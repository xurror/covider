package com.nghom.covideradmin;

import android.app.Application;

import com.nghom.covideradmin.data.AppDatabase;
import com.nghom.covideradmin.utils.SharedPrefs;

public class CoviderAdminApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        new SharedPrefs(getApplicationContext());
        AppDatabase appDatabase = AppDatabase.getDatabase(this);
    }
}
