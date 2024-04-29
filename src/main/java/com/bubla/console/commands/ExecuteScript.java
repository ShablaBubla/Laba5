package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.exceptions.WrongCommandFormat;
import com.bubla.console.executer.Application;
import com.bubla.console.executer.Executer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ExecuteScript extends PrimeCommand<String>{
    public ExecuteScript(){super("execute_script file_name : считать и исполнить скрипт из указанного файла");}


    @Override
    public void execute(String args, Application application) {
        if(application.getCmdStack().contains(args)){
            this.setApplication(application);
            System.out.println("Рекурсия запрещена!");
        }
        else{
            application.pushCmd(args);
        try{
            File file = new File(args);
            FileReader reader = new FileReader(file);
            int sym;
            while ((sym=reader.read())!=-1){
                Executer executer = new Executer(application);
                StringBuilder cmd = new StringBuilder();
                while((char)(sym=reader.read())!=' '){
                    cmd.append((char) sym);
                }
                StringBuilder cmd_args = new StringBuilder();
                while((char)(sym=reader.read())!='\n'){
                    if(sym==-1){break;}
                    cmd_args.append((char) sym);
                }
                try{
                    executer.accomplish(cmd.toString(), cmd_args.toString());
                    application = executer.getApplication();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        }
        catch (IOException ex){
            //System.out.println(new WrongCommandFormat("такого файла не существует").getMessage());
            System.out.println(ex.getMessage());
        }
        finally {
            application.popCmd();
            this.setApplication(application);
        }
    }
}}
