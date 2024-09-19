package com.bubla.console.commands;


import com.bubla.console.executer.Executable;
import lombok.Data;


@Data
public abstract class PrimeCommand<T> implements Executable<T>{
    private String description;
    public PrimeCommand(String description){
        this.description = description;
    }
}
