package io.github.yury_developer.hh.starter.autoconfigure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
Зарплата
 */
@Data
public class SalaryDto {

    private Integer from;

    private Integer to;

    private String currency;

    @JsonProperty("gross")
    private boolean gross;  // true - до вычета налогов, false - после

    private String unit;    // MONTH, HOUR, DAY, etc.
}
