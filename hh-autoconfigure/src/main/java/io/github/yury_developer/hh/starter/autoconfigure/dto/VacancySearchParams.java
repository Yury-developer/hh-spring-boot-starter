package io.github.yury_developer.hh.starter.autoconfigure.dto;

import lombok.Builder;
import lombok.Data;

/*
Параметры поиска (request)
 */
@Data
@Builder
public class VacancySearchParams {

    private String text;           // поисковый запрос
    private Integer area;          // регион (113 - Россия)
    private Integer perPage;       // на странице (max 100)
    private Integer page;          // номер страницы (с 0)
    private String schedule;       // remote, fullDay, flexible
    private String experience;     // noExperience, between1And3, between3And6, moreThan6
    private String employment;     // full, part, project, volunteer, internship
    private Integer salary;        // минимальная зарплата
    private Boolean onlyWithSalary; // только с указанной зарплатой
    private String orderBy;        // publication_time, salary_desc, relevance
}
