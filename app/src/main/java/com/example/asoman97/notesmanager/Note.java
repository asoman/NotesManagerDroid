package com.example.asoman97.notesmanager;

/**
 * Created by asoman97 on 29.10.2015.
 */
public class Note {
    private String Title;
    private String Description;
    private boolean IsDone = false;

    public Note(String title, String description) {
        Title = title;
        Description = description;
    }

    public Note(String title, String description,boolean isDone) {
        Title = title;
        Description = description;
        IsDone = isDone;
    }

    public String getTitle(){

        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public  String getShortDescription(){

        return Description.substring(0,80) + "...";
    }

    public void setDone(){
        IsDone = true;
    }

    public boolean isDone() {
        return IsDone;
    }
}
