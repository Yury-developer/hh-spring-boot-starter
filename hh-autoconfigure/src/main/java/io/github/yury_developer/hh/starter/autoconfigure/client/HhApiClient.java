package io.github.yury_developer.hh.starter.autoconfigure.client;

import io.github.yury_developer.hh.starter.autoconfigure.dto.HhResponse;
import io.github.yury_developer.hh.starter.autoconfigure.dto.VacancyDto;
import io.github.yury_developer.hh.starter.autoconfigure.dto.VacancySearchParams;

public interface HhApiClient {

    /**
     * Search vacancies with parameters
     */
    HhResponse<VacancyDto> searchVacancies(VacancySearchParams params);

    /**
     * Get vacancy by ID
     */
    VacancyDto getVacancy(Long id);

    /**
     * Simple search with just text query
     */
    default HhResponse<VacancyDto> searchByText(String text) {
        return searchVacancies(VacancySearchParams.builder()
                .text(text)
                .build());
    }

    /**
     * Search Java developer vacancies in Russia
     */
    default HhResponse<VacancyDto> searchJavaVacancies() {
        return searchVacancies(VacancySearchParams.builder()
                .text("Java разработчик")
                .area(113)
                .build());
    }
}
