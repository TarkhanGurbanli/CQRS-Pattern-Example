package com.example.cqrspatternexample.cqrs.results;

import lombok.Data;

@Data
public class GetCategoryQueryResult {
    private Long categoryId;
    private String name;
}
