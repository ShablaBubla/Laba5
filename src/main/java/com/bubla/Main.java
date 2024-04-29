package com.bubla;

import com.bubla.classes.*;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;
import com.bubla.console.file_managment.Read;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Application application = new Application(new LinkedHashMapOfProducts());
        while(application.isRunnig()){
            Read read = new Read(new File(System.getenv("TEST")));

            Scanner sc = new Scanner(System.in);
            String[] tokens = sc.next().split(" ");

            Executer executer = new Executer(application);
            try {
                executer.accomplish(tokens[0], tokens[1]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
                executer.accomplish(tokens[0], "");
            }
            application = executer.getApplication();
        }
    }
}