package com.bubla;

import com.bubla.classes.*;
import com.bubla.console.executer.CommandManager;
import com.bubla.console.file_managment.Read;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Read read = new Read(System.getenv("FILE_PATH"));
        read.refil();
        LinkedHashMap<String, Product> prodsMap = read.getProducts();
        CommandManager commandManager = new CommandManager(prodsMap);
        System.out.println("Введите help, чтобы вывести справку по доступным командам");
        commandManager.start(System.in);
    }
}