package com.adar.mangapedia.service.impl;

import com.adar.mangapedia.dto.MangaDTO;
import com.adar.mangapedia.mapper.MangaMapper;
import com.adar.mangapedia.reporsitory.MangaRepository;
import com.adar.mangapedia.service.MangaCRUDService;
import com.mongodb.MongoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest(classes = MangaCRUDServiceImpl.class)
public class MangaCRUDServiceImplTest {

    @Autowired
    MangaCRUDService mangaCRUDService;
    @MockBean
    MangaRepository mangaRepository;

    @Test
    public void testCreateMangaOK(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        ResponseEntity<String> responseEntity = mangaCRUDService.createManga(this.genManga());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
     @Test
    public void testCreateMangaBadRequest(){
         Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(MangaMapper.mapTo(this.genManga())));
         ResponseEntity<String> responseEntity = mangaCRUDService.createManga(this.genManga());
         Assertions.assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
     }

    @Test
    public void testCreateMangaInternalServerError(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenThrow(MongoException.class);
        ResponseEntity<String> responseEntity = mangaCRUDService.createManga(this.genManga());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }


    @Test
    public void testFindMangaOK(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(MangaMapper.mapTo(this.genManga())));
        ResponseEntity<String> responseEntity = mangaCRUDService.readManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
    }
    @Test
    public void testFindNotFoundRequest(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        ResponseEntity<String> responseEntity = mangaCRUDService.readManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assertions.assertEquals("Manga [" + this.genManga().getName() + "] no encontrado", responseEntity.getBody().toString());
    }

    @Test
    public void testFindMangaInternalServerError(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenThrow(MongoException.class);
        ResponseEntity<String> responseEntity = mangaCRUDService.readManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }



    @Test
    public void testUpdateMangaOK(){
        Mockito.when(mangaRepository.findById(Mockito.anyString())).thenReturn(Optional.of(MangaMapper.mapTo(this.genManga())));
        ResponseEntity<String> responseEntity = mangaCRUDService.updateManga(this.genManga());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
    @Test
    public void testUpdateMangaBadRequest(){
        Mockito.when(mangaRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        ResponseEntity<String> responseEntity = mangaCRUDService.updateManga(this.genManga());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateMangaInternalServerError(){
        Mockito.when(mangaRepository.findById(Mockito.anyString())).thenThrow(MongoException.class);
        ResponseEntity<String> responseEntity = mangaCRUDService.updateManga(this.genManga());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }



    @Test
    public void testDeleteMangaOK(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(MangaMapper.mapTo(this.genManga())));
        ResponseEntity<String> responseEntity = mangaCRUDService.deleteManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
    @Test
    public void testDeleteMangaBadRequest(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        ResponseEntity<String> responseEntity = mangaCRUDService.deleteManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteMangaInternalServerError(){
        Mockito.when(mangaRepository.findByName(Mockito.anyString())).thenThrow(MongoException.class);
        ResponseEntity<String> responseEntity = mangaCRUDService.deleteManga(this.genManga().getName());
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }


    private MangaDTO genManga() {
         MangaDTO manga = new MangaDTO();
         manga.setId("123");
         manga.setName("Manga test");
         manga.setChapters("10");
         manga.setVolumes("1");
         manga.setAuthorName("autor del manga");
         manga.setReleaseDate(LocalDate.parse("2000-12-31"));
         manga.setScore(9L);
         manga.setAuthorName("x");
         return manga;
    }


}
