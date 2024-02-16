package com.example.cqrspatternexample.cqrs.results;

import lombok.Data;

@Data
public class GetCategoryByIdQueryResult {
    private Long categoryId;
    private String name;
}
