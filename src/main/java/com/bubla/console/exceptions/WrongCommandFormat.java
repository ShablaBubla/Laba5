package com.bubla.console.exceptions;

public class WrongCommandFormat extends Exception{
    public WrongCommandFormat(String msg){
        super("Неверный формат аргумента: " + msg);
    }
}
