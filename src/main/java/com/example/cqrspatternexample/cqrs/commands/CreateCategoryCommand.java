package com.example.cqrspatternexample.cqrs.commands;

import lombok.Data;

@Data
public class CreateCategoryCommand {
    private String name;
}
