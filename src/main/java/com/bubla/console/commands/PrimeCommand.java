package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executable;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
public abstract class PrimeCommand<T> implements Executable<T>{
    private String description;
    private Application application;
    public PrimeCommand(String description){}
}
