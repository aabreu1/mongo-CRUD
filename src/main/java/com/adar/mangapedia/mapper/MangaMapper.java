package com.adar.mangapedia.mapper;

import com.adar.mangapedia.dto.MangaDTO;
import com.adar.mangapedia.dto.VolumeDTO;
import com.adar.mangapedia.model.Manga;
import com.adar.mangapedia.model.Volume;

import java.util.stream.Collectors;

public class MangaMapper {
    private MangaMapper(){}

    public static Manga mapTo(MangaDTO mangaDTO){
        Manga manga = new Manga();
        manga.setId(mangaDTO.getId());
        manga.setScore(mangaDTO.getScore());
        manga.setVolumes(mangaDTO.getVolumes().stream().map(MangaMapper::mapTo).collect(Collectors.toList()));
        manga.setName(mangaDTO.getName());
        manga.setAuthorName(mangaDTO.getAuthorName());
        manga.setType(mangaDTO.getType());
        manga.setDescription(mangaDTO.getDescription());
        return manga;
    }

    private static Volume mapTo(VolumeDTO volumeDTO) {
        return new Volume(volumeDTO.getNumber(),
                volumeDTO.getChapters(),
                volumeDTO.getCoverUrl(),
                volumeDTO.getReleaseDate()
        );
    }

    public static MangaDTO mapTo(Manga manga){
        MangaDTO mangaDTO = new MangaDTO();
        mangaDTO.setId(manga.getId());
        mangaDTO.setScore(manga.getScore());
        mangaDTO.setVolumes(manga.getVolumes().stream().map(MangaMapper::mapTo).collect(Collectors.toList()));
        mangaDTO.setName(manga.getName());
        mangaDTO.setAuthorName(manga.getAuthorName());
        mangaDTO.setType(manga.getType());
        mangaDTO.setDescription(manga.getDescription());
        return mangaDTO;
    }

    private static VolumeDTO mapTo(Volume volume) {
        return new VolumeDTO(volume.getNumber(),
                volume.getChapters(),
                volume.getCoverUrl(),
                volume.getReleaseDate()
        );
    }
}
