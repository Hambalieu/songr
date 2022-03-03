package com.Hambalieu.songr.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    int length;
    int trackNumber;
    @ManyToOne
    String album;

    public Song(){

    }


    public Song(String title, int length, int trackNumber, String album) {
        this.title = title;
        this.length = length * 60;
        this.trackNumber = trackNumber;
        this.album = album;
    }
    public Album getSongAtAlbum(){
        return songAtAlbum;
    }

    public void setSongAtAlbum(Album songAtAlbum){
        this.songAtAlbum = songAtAlbum;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
