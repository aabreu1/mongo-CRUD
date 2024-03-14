package com.adar.mangapedia.service;

import com.adar.mangapedia.model.Manga;
import org.springframework.http.ResponseEntity;


public interface MangaCRUDService {

    public ResponseEntity<String> createManga(Manga manga);

    public ResponseEntity<String> updateManga(Manga manga);

    public ResponseEntity readManga(String mangaName);

    public ResponseEntity<String> deleteManga(String name);
}
