package com.example.asoman97.notesmanager;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoman97 on 30.10.2015.
 */
public class PreferencesDriver<T> {
    private SharedPreferences preferences;
    private int countPreferences;

    public PreferencesDriver(SharedPreferences Preferences) {
        preferences = Preferences;

    }


    public ArrayList<Note> getAllDataNotes(){           //Потом получше изучу дженерики. Сейчас пока сложна адекватно написать универсальный драйвер
        countPreferences = preferences.getInt("count_preferences",0);
        ArrayList<Note> result = new ArrayList<Note>();
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

    public void newNote(String Title, String Description)
    {
        int id = countPreferences+1;
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("count_preferences", countPreferences+1);
        edit.putString("title_"+id,Title);
        edit.putString("description_"+id,Description);
        edit.commit();
    }

}
