package com.bubla;

import com.bubla.classes.*;
import com.bubla.console.exceptions.WrongCommandFormat;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;
import com.bubla.console.file_managment.Read;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Read read = new Read(System.getenv("FILE_PATH"));
        read.refil();
        LinkedHashMap<String, Product> prodsMap = read.getProducts();
        LinkedHashMapOfProducts linkedHashMapOfProducts = new LinkedHashMapOfProducts(prodsMap);
        Application application = new Application(linkedHashMapOfProducts);
        Executer executer = new Executer();
        System.out.println("Для справки введите help");
        while (application.isRunnig()) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            Boolean isCMD = true;
            StringBuilder cmd = new StringBuilder();
            StringBuilder arg = new StringBuilder();
            for (char w : line.toCharArray()) {
                if (w == ' ') {
                    isCMD = false;
                } else {
                    if (isCMD) {
                        cmd.append(w);
                    } else {
                        arg.append(w);
                    }
                }
            }

            try {
                executer.accomplish(cmd.toString(), arg.toString(), application);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }}