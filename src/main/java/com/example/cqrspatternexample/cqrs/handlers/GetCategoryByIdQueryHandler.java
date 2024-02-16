package com.example.cqrspatternexample.cqrs.handlers;

import com.example.cqrspatternexample.cqrs.queries.GetCategoryByIdQuery;
import com.example.cqrspatternexample.cqrs.results.GetCategoryByIdQueryResult;
import com.example.cqrspatternexample.entity.Category;
import com.example.cqrspatternexample.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCategoryByIdQueryHandler {
    private final CategoryRepository repository;

    public GetCategoryByIdQueryHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    public GetCategoryByIdQueryResult handle(GetCategoryByIdQuery query) {
        Optional<Category> optionalCategory = repository.findById(query.getId());

        return optionalCategory.map(category -> {
            GetCategoryByIdQueryResult result = new GetCategoryByIdQueryResult();
            result.setCategoryId(category.getCategoryId());
            result.setName(category.getName());
            return result;
        }).orElse(null);
    }
}
