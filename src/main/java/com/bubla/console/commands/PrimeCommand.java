package com.bubla.console.commands;


import com.bubla.console.executer.Executable;
import lombok.Data;

/** Класс описывающий щаблон команды */
@Data
public abstract class PrimeCommand implements Executable {
    private String description;
    public PrimeCommand(String description){
        this.description = description;
    }
}
