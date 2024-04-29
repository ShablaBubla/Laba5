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
        //Read read = new Read(new File(System.getenv("FILE_PATH")));
        System.out.println("Для справки введите help");
        while(application.isRunnig()){
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            Boolean isCMD = true;
            StringBuilder cmd = new StringBuilder();
            StringBuilder arg = new StringBuilder();
            for(char w: line.toCharArray()){
                if(w == ' '){
                    isCMD = false;
                }
                else {
                    if(isCMD){
                        cmd.append(w);
                    }
                    else {
                        arg.append(w);
                    }
                }
            }
            Executer executer = new Executer(application);
            try {
                executer.accomplish(cmd.toString(), arg.toString());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            application = executer.getApplication();


        }
    }
}