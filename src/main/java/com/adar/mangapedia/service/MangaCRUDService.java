package com.adar.mangapedia.service;

import com.adar.mangapedia.model.Manga;


public interface MangaCRUDService {

    public Manga createManga(Manga manga);

    public Manga updateManga(Manga manga);

    public Manga readManga(String mangaName);

    public void deleteManga(String name);
}
