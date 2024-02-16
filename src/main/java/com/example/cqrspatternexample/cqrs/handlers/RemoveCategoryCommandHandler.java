package com.example.cqrspatternexample.cqrs.handlers;

import com.example.cqrspatternexample.entity.Category;
import com.example.cqrspatternexample.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveCategoryCommandHandler {
    private final CategoryRepository repository;

    public RemoveCategoryCommandHandler(CategoryRepository repository) {
        this.repository = repository;
    }

    public void handle(Long categoryId){
        Optional<Category> optionalCategory = repository.findById(categoryId);

        optionalCategory.ifPresent(category -> repository.delete(category));
    }
}
