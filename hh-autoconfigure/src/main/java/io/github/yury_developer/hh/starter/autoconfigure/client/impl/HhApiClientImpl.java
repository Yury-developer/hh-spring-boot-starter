package io.github.yury_developer.hh.starter.autoconfigure.client.impl;

import io.github.yury_developer.hh.starter.autoconfigure.client.HhApiClient;
import io.github.yury_developer.hh.starter.autoconfigure.dto.HhResponse;
import io.github.yury_developer.hh.starter.autoconfigure.dto.VacancyDto;
import io.github.yury_developer.hh.starter.autoconfigure.dto.VacancySearchParams;
import io.github.yury_developer.hh.starter.autoconfigure.properties.HhProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
public class HhApiClientImpl implements HhApiClient {

    private final RestTemplate restTemplate;
    private final HhProperties properties;

    public HhApiClientImpl(HhProperties properties) {
        this.properties = properties;
        this.restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(properties.getConnectTimeout()))
                .setReadTimeout(Duration.ofMillis(properties.getReadTimeout()))
                .defaultHeader("User-Agent", properties.getUserAgent())
                .build();
    }

    @Override
    public HhResponse<VacancyDto> searchVacancies(VacancySearchParams params) {
        if (!properties.isEnabled()) {
            log.warn("HH.ru client is disabled");
            return new HhResponse<>();
        }

        String url = buildSearchUrl(params);
        log.debug("Searching vacancies: {}", url);

        ResponseEntity<HhResponse<VacancyDto>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<HhResponse<VacancyDto>>() {}
        );

        return response.getBody();
    }

    @Override
    public VacancyDto getVacancy(Long id) {
        String url = properties.getBaseUrl() + "/vacancies/" + id;
        log.debug("Fetching vacancy: {}", url);

        return restTemplate.getForObject(url, VacancyDto.class);
    }

    private String buildSearchUrl(VacancySearchParams params) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(properties.getBaseUrl() + "/vacancies");

        if (params.getText() != null) {
            builder.queryParam("text", params.getText());
        }
        if (params.getArea() != null) {
            builder.queryParam("area", params.getArea());
        } else {
            builder.queryParam("area", properties.getDefaultArea());
        }
        if (params.getPerPage() != null) {
            builder.queryParam("per_page", params.getPerPage());
        } else {
            builder.queryParam("per_page", properties.getDefaultPerPage());
        }
        if (params.getPage() != null) {
            builder.queryParam("page", params.getPage());
        }
        if (params.getSchedule() != null) {
            builder.queryParam("schedule", params.getSchedule());
        }
        if (params.getExperience() != null) {
            builder.queryParam("experience", params.getExperience());
        }
        if (params.getEmployment() != null) {
            builder.queryParam("employment", params.getEmployment());
        }
        if (params.getSalary() != null) {
            builder.queryParam("salary", params.getSalary());
        }
        if (params.getOnlyWithSalary() != null) {
            builder.queryParam("only_with_salary", params.getOnlyWithSalary());
        }
        if (params.getOrderBy() != null) {
            builder.queryParam("order_by", params.getOrderBy());
        }

        return builder.build().toUriString();
    }
}
