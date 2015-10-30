package com.example.asoman97.notesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateButtonClick();
            }
        });
    }

    private void onCreateButtonClick(){
        String title = ((EditText)findViewById(R.id.title_create)).getText().toString();
        String description = ((EditText)findViewById(R.id.description_create)).getText().toString();
        if(!title.isEmpty()&&!description.isEmpty())
        {
            PreferencesDriver<Note> preferences = new PreferencesDriver<Note>(getSharedPreferences("NotesPreferences", MODE_PRIVATE));
            preferences.newNote(title,description);
            this.finish();
        }
        else
            Toast.makeText(this,"Заполните все поля!",Toast.LENGTH_SHORT).show();


    }


}
