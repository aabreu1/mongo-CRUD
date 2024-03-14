package com.adar.mangapedia.controller;

import com.adar.mangapedia.dto.MangaDTO;
import com.adar.mangapedia.service.MangaCRUDService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MangaController.class)
public class MangaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MangaCRUDService mangaCRUDService;

    @Test
    public void post_create_manga() throws Exception {
        Mockito.when(mangaCRUDService.createManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.ok("creado"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/manga/create")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void post_create_manga_existe() throws Exception {
        Mockito.when(mangaCRUDService.createManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.badRequest().body("creado"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/manga/create")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void post_create_manga_error() throws Exception {
        Mockito.when(mangaCRUDService.createManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.internalServerError().body("creado"));
        mvc.perform(MockMvcRequestBuilders
                        .post("/manga/create")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void post_update_manga() throws Exception {
        Mockito.when(mangaCRUDService.updateManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.ok("actualizado"));
        mvc.perform(MockMvcRequestBuilders
                        .put("/manga/update")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void post_update_manga_bad_request() throws Exception {
        Mockito.when(mangaCRUDService.updateManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.badRequest().body("no existe"));
        mvc.perform(MockMvcRequestBuilders
                        .put("/manga/update")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test
    public void post_update_manga_error() throws Exception {
        Mockito.when(mangaCRUDService.updateManga(Mockito.any(MangaDTO.class))).thenReturn(ResponseEntity.internalServerError().body("no existe"));
        mvc.perform(MockMvcRequestBuilders
                        .put("/manga/update")
                        .content(this.asJsonString(new MangaDTO()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }



    @Test
    public void get_find_manga_by_name() throws Exception {
        Mockito.when(mangaCRUDService.readManga(Mockito.anyString())).thenReturn(ResponseEntity.ok(this.genManga()));

        mvc.perform(MockMvcRequestBuilders
                        .get("/manga/find/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
    }

    @Test
    public void get_find_manga_by_name_not_foud() throws Exception {
        Mockito.when(mangaCRUDService.readManga(Mockito.anyString())).thenReturn(ResponseEntity.ok("no encontrado"));

        mvc.perform(MockMvcRequestBuilders
                        .get("/manga/find/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").doesNotExist());
    }

    @Test
    public void get_find_manga_by_name_internal_server_error() throws Exception {
        Mockito.when(mangaCRUDService.readManga(Mockito.anyString())).thenReturn(ResponseEntity.internalServerError().body("no encontrado"));

        mvc.perform(MockMvcRequestBuilders
                        .get("/manga/find/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").doesNotExist());
    }


    @Test
    public void delete_manga_by_name() throws Exception {
        Mockito.when(mangaCRUDService.deleteManga(Mockito.anyString())).thenReturn(ResponseEntity.ok("borrado"));

        mvc.perform(MockMvcRequestBuilders
                        .delete("/manga/delete/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void delete_manga_by_name_not_foud() throws Exception {
        Mockito.when(mangaCRUDService.deleteManga(Mockito.anyString())).thenReturn(ResponseEntity.badRequest().body("no encontrado"));

        mvc.perform(MockMvcRequestBuilders
                        .delete("/manga/delete/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void delete_manga_by_name_internal_server_error() throws Exception {
        Mockito.when(mangaCRUDService.deleteManga(Mockito.anyString())).thenReturn(ResponseEntity.internalServerError().body("error"));

        mvc.perform(MockMvcRequestBuilders
                        .delete("/manga/delete/{name}", this.genManga().getName())
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError());
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
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


