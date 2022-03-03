package com.Hambalieu.songr.controller;


import com.Hambalieu.songr.model.Album;
import com.Hambalieu.songr.model.Song;
import com.Hambalieu.songr.repository.AlbumRepository;
import com.Hambalieu.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;


    @GetMapping("/songs")
    public String getSong(Model m){
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("album", albums);
        return "addSong";
    }
    @GetMapping("/songs/{albumId}")
    public String getOneAlbum(@PathVariable long albumId, Model m) {
        Album album = albumRepository.getById(albumId);
        m.addAttribute("song", album.getTitle());
        return "songs";
    }


    @PostMapping("/songs")
    public RedirectView addSong(long albumId, String title, int length, int trackNumber, String album) {
        Album songAtAlbum = albumRepository.getById(albumId);
        Song songToAdd = new Song(title, length, trackNumber,album);
        songToAdd.setSongAtAlbum(songAtAlbum);
        songRepository.save(songToAdd);
        return new RedirectView("/albums");
    }


}