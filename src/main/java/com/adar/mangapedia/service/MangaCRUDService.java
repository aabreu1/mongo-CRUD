package com.adar.mangapedia.service;

import com.adar.mangapedia.dto.MangaDTO;
import org.springframework.http.ResponseEntity;


public interface MangaCRUDService {

    public ResponseEntity<String> createManga(MangaDTO manga);

    public ResponseEntity<String> updateManga(MangaDTO manga);

    public ResponseEntity readManga(String mangaName);

    public ResponseEntity<String> deleteManga(String mangaName);
}
