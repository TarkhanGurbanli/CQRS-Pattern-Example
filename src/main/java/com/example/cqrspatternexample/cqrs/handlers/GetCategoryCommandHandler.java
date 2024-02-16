package com.example.cqrspatternexample.cqrs.handlers;

import com.example.cqrspatternexample.cqrs.results.GetCategoryQueryResult;
import com.example.cqrspatternexample.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetCategoryCommandHandler {
    private final CategoryRepository repository;

    public GetCategoryCommandHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<GetCategoryQueryResult> handle() {
        List<GetCategoryQueryResult> results = repository.findAll().stream()
                .map(category -> {
                    GetCategoryQueryResult result = new GetCategoryQueryResult();
                    result.setCategoryId(category.getCategoryId());
                    result.setName(category.getName());
                    return result;
                })
                .collect(Collectors.toList());

        return results;
    }
}
