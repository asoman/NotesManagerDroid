package com.example.asoman97.notesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    PreferencesDriver<Note> preferences;

    ArrayList<Note> notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = new PreferencesDriver<Note>(getSharedPreferences("NotesPreferences", MODE_PRIVATE));   //Подключение preferences
        createOnClickListeners();

    }

    @Override
    protected void onResume() {
        super.onResume();
        notes = preferences.getAllDataNotes();
        ((ListView) findViewById(R.id.NotesList)).setAdapter(new NoteAdapter(this, R.layout.note_template, notes));    //Подключение адаптера к листу
    }

    private void createOnClickListeners() {

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newNote();
            }
        });

        ((ListView)findViewById(R.id.NotesList)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openNote(position);
            }
        });


    }

    private void newNote() {
        Intent intent = new Intent(this,NewNoteActivity.class);
        startActivity(intent);
    }

    private void openNote(int position){


    }
}