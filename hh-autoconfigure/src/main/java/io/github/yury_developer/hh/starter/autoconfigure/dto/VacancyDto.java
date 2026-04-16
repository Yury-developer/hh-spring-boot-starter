package io.github.yury_developer.hh.starter.autoconfigure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/*
Вакансия (основной DTO)
 */
@Data
public class VacancyDto {

    private Long id;

    private String name;

    private String description;

    private EmployerDto employer;

    private SalaryDto salary;

    private Area area;

    private String experience;

    private String employment;  // full, part, project, etc.

    private String schedule;    // remote, fullDay, flexible, etc.

    @JsonProperty("published_at")
    private LocalDateTime publishedAt;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("alternate_url")
    private String alternateUrl;

    private Boolean archived;

    private List<String> keySkills;

    @Data
    public static class Area {
        private Long id;
        private String name;
        private String url;
    }
}
