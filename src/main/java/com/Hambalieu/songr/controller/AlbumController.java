package com.Hambalieu.songr.controller;

import com.Hambalieu.songr.model.Album;
import com.Hambalieu.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;
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

//        ArrayList<Object> arrayList = new ArrayList<>();
//        Album albumKendrick = new Album("good kid, m.A.A.d city", "Kendrick Lamar", 16, 4093, "https://coverartarchive.org/release-group/499c19c8-0dab-4824-884b-6191d145e95b/front");
//        Album albumBobMarley = new Album("Exodus", "Bob Marley", 12, 3400, "https://upload.wikimedia.org/wikipedia/en/b/b8/Bob_Marley_and_the_Wailers_-_Exodus.png");
//        Album albumNipseyHussle = new Album("Victory Lap", "Nipsey Hussle", 16, 3980, "https://archive.org/download/mbid-7dd4f90f-fde7-4118-b65b-da6926d73ad3/mbid-7dd4f90f-fde7-4118-b65b-da6926d73ad3-23018576788_thumb500.jpg");
//
//        arrayList.add(albumKendrick);
//        arrayList.add(albumBobMarley);
//        arrayList.add(albumNipseyHussle);
//
//        m.addAttribute("albums", albumKendrick);
//        m.addAttribute("albums1", albumBobMarley);
//        m.addAttribute("albums2", albumNipseyHussle);
//        return "albums.html";
    }



    @PostMapping("/albums")
    public RedirectView addAlbum(String title,String artist, int songCount, double length, String imageUrl)
    {
        Album addYourAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(addYourAlbum);
        return new RedirectView("/albums");
    }
}
