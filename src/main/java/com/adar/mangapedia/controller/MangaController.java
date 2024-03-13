package com.adar.mangapedia.controller;


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
    public ResponseEntity<String> createManga(@RequestBody Manga manga){
        //TODO: dividir DTO de document model
        mangaCRUDService.createManga(manga);
        return ResponseEntity.ok("Manga {"+manga.getName()+"} Registrado");
    }

    @GetMapping(value = "/find/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Manga> findManga(@PathVariable String name){
        return ResponseEntity.ok(mangaCRUDService.readManga(name));
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> updateManga(@RequestBody Manga manga){
        mangaCRUDService.updateManga(manga);
        return ResponseEntity.ok("Manga {"+manga.getName()+"} Actualizado");
    }

    @DeleteMapping (value = "/delete/{name}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> deleteManga(@PathVariable String name){
        mangaCRUDService.deleteManga(name);
        return ResponseEntity.ok("Manga {"+name+"} Eliminado");
    }

}
