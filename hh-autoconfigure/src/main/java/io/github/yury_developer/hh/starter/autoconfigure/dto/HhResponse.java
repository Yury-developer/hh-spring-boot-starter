package io.github.yury_developer.hh.starter.autoconfigure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/*
Базовый ответ с пагинацией
 */
@Data
public class HhResponse<T> {

    private int found;

    private int page;

    @JsonProperty("per_page")
    private int perPage;

    private int pages;

    private List<T> items;
}
