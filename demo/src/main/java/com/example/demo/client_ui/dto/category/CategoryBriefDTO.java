package com.example.demo.client_ui.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryBriefDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("unit")
    private String unit;
}
