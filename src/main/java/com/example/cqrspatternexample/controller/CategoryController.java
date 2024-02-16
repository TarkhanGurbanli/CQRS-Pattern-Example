package com.example.cqrspatternexample.controller;

import com.example.cqrspatternexample.cqrs.commands.CreateCategoryCommand;
import com.example.cqrspatternexample.cqrs.commands.UpdateCategoryCommand;
import com.example.cqrspatternexample.cqrs.handlers.*;
import com.example.cqrspatternexample.cqrs.queries.GetCategoryByIdQuery;
import com.example.cqrspatternexample.cqrs.results.GetCategoryByIdQueryResult;
import com.example.cqrspatternexample.cqrs.results.GetCategoryQueryResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final GetCategoryCommandHandler getCategoryCommandHandler;
    private final GetCategoryByIdQueryHandler getCategoryByIdQueryHandler;
    private final CreateCategoryCommandHandler createCategoryCommandHandler;
    private final UpdateCategoryCommandHandler updateCategoryCommandHandler;
    private final RemoveCategoryCommandHandler removeCategoryCommandHandler;

    public CategoryController(GetCategoryCommandHandler getCategoryCommandHandler,
                              GetCategoryByIdQueryHandler getCategoryByIdQueryHandler,
                              CreateCategoryCommandHandler createCategoryCommandHandler,
                              UpdateCategoryCommandHandler updateCategoryCommandHandler,
                              RemoveCategoryCommandHandler removeCategoryCommandHandler) {
        this.getCategoryCommandHandler = getCategoryCommandHandler;
        this.getCategoryByIdQueryHandler = getCategoryByIdQueryHandler;
        this.createCategoryCommandHandler = createCategoryCommandHandler;
        this.updateCategoryCommandHandler = updateCategoryCommandHandler;
        this.removeCategoryCommandHandler = removeCategoryCommandHandler;
    }

    @GetMapping
    public List<GetCategoryQueryResult> getAllCategories() {
        return getCategoryCommandHandler.handle();
    }

    @GetMapping("/{categoryId}")
    public GetCategoryByIdQueryResult getCategoryById(@PathVariable Long categoryId) {
        return getCategoryByIdQueryHandler.handle(new GetCategoryByIdQuery(categoryId));
    }

    @PostMapping
    public void createCategory(@RequestBody CreateCategoryCommand command) {
        createCategoryCommandHandler.handle(command);
    }

    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId, @RequestBody UpdateCategoryCommand command) {
        updateCategoryCommandHandler.handle(command);
    }

    @DeleteMapping("/{categoryId}")
    public void removeCategory(@PathVariable Long categoryId) {
        removeCategoryCommandHandler.handle(categoryId);
    }
}
