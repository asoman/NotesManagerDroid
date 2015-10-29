package com.example.asoman97.notesmanager;

import android.content.SharedPreferences;

/**
 * Created by asoman97 on 30.10.2015.
 */
public class PreferencesDriver {
    SharedPreferences preferences;
    int countPrefernces;

    public PreferencesDriver(SharedPreferences Preferences) {
        preferences = Preferences;
        countPrefernces = preferences.getInt("count_preferences",0);
    }


}
