package com.example.cqrspatternexample.cqrs.commands;

import lombok.Data;

@Data
public class RemoveCategoryCommand {
    private Long id;
    public RemoveCategoryCommand(Long id){
        this.id = id;
    }
}
