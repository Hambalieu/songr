package com.Hambalieu.songr.repository;

import com.Hambalieu.songr.model.Album;
import com.Hambalieu.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
    public Song findSongByTitleandAlbum(String title, Album album);
}
