package com.Hambalieu.songr.controller;

import com.Hambalieu.songr.model.Album;
import com.Hambalieu.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;



import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAlbums(Object album, Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "albums.html";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, double length, String imageUrl)
    {
        Album addYourAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(addYourAlbum);
        return new RedirectView("/albums");
    }

    @GetMapping("/edit-album/{title}")
    public String editAlbumView(@PathVariable String title, Model m){
        Album albumToEdit = albumRepository.findByTitle(title);
        m.addAttribute("album", albumToEdit);
      return "edit-album.html";
    }
    @PutMapping ("/edit-album")
    public RedirectView editAlbum(long id, String title, String artist, int songCount, double length, String imageUrl){
        Album  albumToEdit = albumRepository.findById(id).orElseThrow();
        albumToEdit.setTitle(title);
        albumToEdit.setArtist(artist);
        albumToEdit.setSongCount(songCount);
        albumToEdit.setLength(length);
        albumToEdit.setImageUrl(imageUrl);
        albumRepository.save(albumToEdit);
        return new RedirectView("/albums");
    }

    @DeleteMapping("/delete-album")
    public  RedirectView deleteAlbum(long id){
       albumRepository.deleteById(id);
       return new RedirectView("/albums");
    }

}
