package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;
import com.bubla.console.file_managment.Write;

import java.io.*;

public class Save extends PrimeCommand<String>{
    public Save(){super("save : сохранить коллекцию в файл");}

    @Override
    public void execute(String args, Application application){
            Write write = new Write(application.getProducts().getProducts());
            write.record();
    }
}
