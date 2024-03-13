package com.adar.mangapedia.reporsitory;

import com.adar.mangapedia.model.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangaRepository extends MongoRepository<Manga, String> {

    public Manga findByName(String name);
}
