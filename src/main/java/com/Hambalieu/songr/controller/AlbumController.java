package com.Hambalieu.songr.controller;

import com.Hambalieu.songr.model.Album;
import com.Hambalieu.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public RedirectView addAlbum(String title,String artist, int songCount, double length, String imageUrl)
    {
        Album addYourAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(addYourAlbum);
        return new RedirectView("/albums");
    }
}
