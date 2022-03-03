package com.Hambalieu.songr.repository;

import com.Hambalieu.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, Long>
{
    Album findByTitle(String title);
}
