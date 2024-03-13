package com.adar.mangapedia.service.impl;

import com.adar.mangapedia.model.Manga;
import com.adar.mangapedia.reporsitory.MangaRepository;
import com.adar.mangapedia.service.MangaCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangaCRUDServiceImpl implements MangaCRUDService {

    private final MangaRepository mangaRepository;

    @Autowired
    public MangaCRUDServiceImpl(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }


    @Override
    public Manga createManga(Manga manga) {
        if( mangaRepository.findByName(manga.getName()) != null) {
            //implementar already exist
            throw new RuntimeException();
        }
        return mangaRepository.save(manga);
    }

    @Override
    public Manga readManda(String mangaName) {
        return mangaRepository.findByName(mangaName);
    }
    @Override
    public Manga updateManga(Manga manga) {
        if(manga.getId() != null
            && mangaRepository.findByName(manga.getName()) != null)
        {
            return mangaRepository.save(manga);

        }
        //implementar does not exist
        throw new RuntimeException();
    }


    @Override
    public void deleteManga(String name) {
        //TODO: valida que exista
        mangaRepository.delete(mangaRepository.findByName(name));
    }
}
