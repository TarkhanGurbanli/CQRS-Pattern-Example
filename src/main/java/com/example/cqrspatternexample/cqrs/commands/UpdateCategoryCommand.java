package com.example.cqrspatternexample.cqrs.commands;

import lombok.Data;

@Data
public class UpdateCategoryCommand {
    private Long categoryId;
    private String name;
}
