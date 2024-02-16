package com.example.cqrspatternexample.cqrs.handlers;

import com.example.cqrspatternexample.cqrs.commands.CreateCategoryCommand;
import com.example.cqrspatternexample.entity.Category;
import com.example.cqrspatternexample.repository.CategoryRepository;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryCommandHandler {
    private final CategoryRepository _repository;

    public CreateCategoryCommandHandler(CategoryRepository repository) {
        _repository = repository;
    }

    public void handle(CreateCategoryCommand command) {
        Category newCategory = new Category();
        newCategory.setName(command.getName());
        _repository.save(newCategory);
    }
}
