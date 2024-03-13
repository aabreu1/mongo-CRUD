package com.adar.mangapedia.controller;


import com.adar.mangapedia.model.Manga;
import com.adar.mangapedia.service.MangaCRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Manga")
public class MangaController {

    private final MangaCRUDService mangaCRUDService;
    public MangaController(MangaCRUDService mangaCRUDService) {
        this.mangaCRUDService = mangaCRUDService;
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> createManga(@RequestBody Manga manga){
        mangaCRUDService.createManga(manga);
        return ResponseEntity.ok("Manga Registrado");
    }

    @GetMapping(value = "/find/{name}", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Manga> findManga(@PathVariable String name){
        return ResponseEntity.ok(mangaCRUDService.readManda(name));
    }

    @PutMapping(value = "/create", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> updateManga(@RequestBody Manga manga){
        mangaCRUDService.updateManga(manga);
        return ResponseEntity.ok("Manga Actualizado");
    }

    @DeleteMapping (value = "/delete/{name}", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> deleteManga(@RequestBody String name){
        mangaCRUDService.deleteManga(name);
        return ResponseEntity.ok("Manga Actualizado");
    }

}
