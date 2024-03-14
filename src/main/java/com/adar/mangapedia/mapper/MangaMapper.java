package com.adar.mangapedia.mapper;

import com.adar.mangapedia.dto.MangaDTO;
import com.adar.mangapedia.model.Manga;

public class MangaMapper {
    private MangaMapper(){}

    public static Manga mapTo(MangaDTO mangaDTO){
        Manga manga = new Manga();
        manga.setId(mangaDTO.getId());
        manga.setScore(mangaDTO.getScore());
        manga.setVolumes(mangaDTO.getVolumes());
        manga.setName(mangaDTO.getName());
        manga.setChapters(mangaDTO.getChapters());
        manga.setReleaseDate(mangaDTO.getReleaseDate());
        manga.setAuthorName(mangaDTO.getAuthorName());
        manga.setCover(mangaDTO.getCover());
        manga.setType(mangaDTO.getType());
        manga.setDescription(mangaDTO.getDescription());
        return manga;
    }

    public static MangaDTO mapTo(Manga manga){
        MangaDTO mangaDTO = new MangaDTO();
        mangaDTO.setId(manga.getId());
        mangaDTO.setScore(manga.getScore());
        mangaDTO.setVolumes(manga.getVolumes());
        mangaDTO.setName(manga.getName());
        mangaDTO.setChapters(manga.getChapters());
        mangaDTO.setReleaseDate(manga.getReleaseDate());
        mangaDTO.setAuthorName(manga.getAuthorName());
        mangaDTO.setCover(manga.getCover());
        mangaDTO.setType(manga.getType());
        mangaDTO.setDescription(manga.getDescription());
        return mangaDTO;
    }

}
