package com.bubla.console.exceptions;

public class NoSuchCommandException extends Exception {
    public NoSuchCommandException(String msg){super("Комнада " + msg + " не существует");}
}
