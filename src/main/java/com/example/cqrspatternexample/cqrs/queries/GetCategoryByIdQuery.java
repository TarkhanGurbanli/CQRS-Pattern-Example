package com.example.cqrspatternexample.cqrs.queries;

import lombok.Data;

@Data
public class GetCategoryByIdQuery {
    private Long id;

    public GetCategoryByIdQuery(Long id) {
        this.id = id;
    }
}
