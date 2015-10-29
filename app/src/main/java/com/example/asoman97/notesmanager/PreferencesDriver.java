package com.example.asoman97.notesmanager;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoman97 on 30.10.2015.
 */
public class PreferencesDriver<T> {
    SharedPreferences preferences;
    int countPreferences;

    public PreferencesDriver(SharedPreferences Preferences) {
        preferences = Preferences;
        countPreferences = preferences.getInt("count_preferences",0);
    }


    public ArrayList<Note> GetAllDataNotes(){           //Потом получше изучу дженерики. Сейчас пока сложна адекватно написать универсальный драйвер
        ArrayList<Note> result = new ArrayList<>();
        for(int i = 0; i<countPreferences; i++)
        {
            result.add(new Note (
                    preferences.getString("title_"+i,null),
                    preferences.getString("description_"+i,null),
                    preferences.getBoolean("is_done_"+i,false)
            ));
        }
        return result;
    }


}
