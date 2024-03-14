package com.adar.mangapedia.controller;


import com.adar.mangapedia.dto.MangaDTO;
import com.adar.mangapedia.model.Manga;
import com.adar.mangapedia.service.MangaCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manga")
public class MangaController {

    private final MangaCRUDService mangaCRUDService;
    public MangaController(MangaCRUDService mangaCRUDService) {
        this.mangaCRUDService = mangaCRUDService;
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> createManga(@RequestBody MangaDTO manga){
        return mangaCRUDService.createManga(manga);
    }

    @GetMapping(value = "/find/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity findManga(@PathVariable String name){
        return mangaCRUDService.readManga(name);
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> updateManga(@RequestBody MangaDTO manga){
        return mangaCRUDService.updateManga(manga);
    }

    @DeleteMapping (value = "/delete/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> deleteManga(@PathVariable String name){
        return mangaCRUDService.deleteManga(name);
    }

}
