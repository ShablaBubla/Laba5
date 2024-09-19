package com.bubla.console.executer;


public interface Executable<T>{
    void execute(T args, Application application);
}
