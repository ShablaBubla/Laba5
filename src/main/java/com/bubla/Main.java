package com.bubla;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.Read;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Application application = new Application(new LinkedHashMapOfProducts());
        while(application.isRunnig()){
            Scanner sc = new Scanner(System.in);
            String[] tokens = sc.next().split(" ");

            Executer executer = new Executer(application);
            executer.accomplish(tokens[0], tokens[1]);
            application = executer.getApplication();
        }
    }
}