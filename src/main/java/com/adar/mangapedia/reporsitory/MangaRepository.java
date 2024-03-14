package com.adar.mangapedia.reporsitory;

import com.adar.mangapedia.model.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MangaRepository extends MongoRepository<Manga, String> {

    public Optional<Manga> findByName(String name);
}
