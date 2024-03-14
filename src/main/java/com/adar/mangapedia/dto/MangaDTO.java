package com.adar.mangapedia.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MangaDTO {

    String id;
    String name;
    String description;
    Set<String> type;
    String chapters;
    String volumes;
    //TODO: variable para iamgen
    Byte[] cover;
    String authorName;
    LocalDate releaseDate;
    Long score;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Set<String> getType() {
        return type;
    }
    public void setType(Set<String> type) {
        this.type = type;
    }
    public String getChapters() {
        return chapters;
    }
    public void setChapters(String chapters) {
        this.chapters = chapters;
    }
    public String getVolumes() {
        return volumes;
    }
    public void setVolumes(String volumes) {
        this.volumes = volumes;
    }
    public Byte[] getCover() {
        return cover;
    }
    public void setCover(Byte[] cover) {
        this.cover = cover;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Long getScore() {
        return score;
    }
    public void setScore(Long score) {
        this.score = score;
    }
}
