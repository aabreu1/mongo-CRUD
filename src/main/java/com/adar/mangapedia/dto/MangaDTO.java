package com.adar.mangapedia.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MangaDTO {

    String id;
    String name;
    String description;
    Set<String> type;
    List<VolumeDTO> volumes;
    String authorName;
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

    public List<VolumeDTO> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<VolumeDTO> volumes) {
        this.volumes = volumes;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getScore() {
        return score;
    }
    public void setScore(Long score) {
        this.score = score;
    }
}
