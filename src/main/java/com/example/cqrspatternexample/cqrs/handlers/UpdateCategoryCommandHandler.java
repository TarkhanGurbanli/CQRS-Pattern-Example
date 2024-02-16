package com.example.cqrspatternexample.cqrs.handlers;

import com.example.cqrspatternexample.cqrs.commands.UpdateCategoryCommand;
import com.example.cqrspatternexample.entity.Category;
import com.example.cqrspatternexample.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCategoryCommandHandler {
    private final CategoryRepository _repository;

    public UpdateCategoryCommandHandler(CategoryRepository repository) {
        _repository = repository;
    }

    public void handle(UpdateCategoryCommand command) {
        Optional<Category> optionalCategory = _repository.findById(command.getCategoryId());

        optionalCategory.ifPresent(category -> {
            category.setName(command.getName());

            _repository.save(category);
        });
    }
}
