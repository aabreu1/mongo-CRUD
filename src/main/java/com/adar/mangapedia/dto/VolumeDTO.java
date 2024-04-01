package com.adar.mangapedia.dto;

import java.time.LocalDate;

public class VolumeDTO {



    Integer number;
    String chapters;
    String coverUrl;
    LocalDate releaseDate;
    public VolumeDTO(Integer number, String chapters, String coverUrl, LocalDate releaseDate) {
        this.number = number;
        this.chapters = chapters;
        this.coverUrl = coverUrl;
        this.releaseDate = releaseDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
