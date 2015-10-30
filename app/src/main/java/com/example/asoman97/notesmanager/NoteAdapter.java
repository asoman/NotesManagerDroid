package com.example.asoman97.notesmanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asoman97 on 30.10.2015.
 */
public class NoteAdapter extends ArrayAdapter{

    Activity activity;
    ArrayList<Note> notes;
    public NoteAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        notes = (ArrayList) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.note_template,null);
        ((TextView)view.findViewById(R.id.title_template))
                .setText(notes.get(position).getTitle());
        ((TextView)view.findViewById(R.id.description_template))
                .setText(notes.get(position).getShortDescription());

        if(notes.get(position).isDone())
            ((LinearLayout)view.findViewById(R.id.background_template))
                    .setBackgroundColor(0xC4CAf50);

        return view;
    }
}
