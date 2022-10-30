package com.example.royalpharmacy.IT213;

public class Note {
    String note;
    String date;
    String about;

    public Note() {
    }

    public Note(String note, String date, String about) {
        this.note = note;
        this.date = date;
        this.about = about;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
