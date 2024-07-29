package com.yesko.project.dto.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class CategoryResponse implements Serializable {
    private Integer id;
    private String name;
    private String description;
}
