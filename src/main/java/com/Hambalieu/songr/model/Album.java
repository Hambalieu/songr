package com.Hambalieu.songr.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {



    public Album(){

    }
    @Id
    //how to generate Id on the backend
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     long id;
     @Column(columnDefinition="text")
     String title;
     String artist;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    List<Song>songsInAlbum;
     int songCount;
     double length;
     String imageUrl;

    public Album(String title, String artist, int songCount, double length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length*60;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
