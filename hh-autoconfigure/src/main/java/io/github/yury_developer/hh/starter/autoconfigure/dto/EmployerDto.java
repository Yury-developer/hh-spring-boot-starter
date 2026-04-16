package io.github.yury_developer.hh.starter.autoconfigure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
Работодатель
 */
@Data
public class EmployerDto {

    private Long id;

    private String name;

    @JsonProperty("logo_urls")
    private LogoUrls logoUrls;

    private String url;

    @JsonProperty("alternate_url")
    private String alternateUrl;

    @Data
    public static class LogoUrls {
        @JsonProperty("90")
        private String logo90;

        @JsonProperty("240")
        private String logo240;

        private String original;
    }
}
