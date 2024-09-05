package com.bubla.console.commands;

import java.util.HashMap;
import java.util.Scanner;

import com.bubla.classes.*;
import com.bubla.console.exceptions.KeyException;
import com.bubla.console.exceptions.WrongCommandFormat;
import com.bubla.console.executer.Application;

public class Insert extends PrimeCommand<String> {
    public Insert(){super("insert null {element} : добавить новый элемент с заданным ключом");}

    @Override
    public void execute(String args, Application application){
        try{Product prod = new Product();
            LinkedHashMapOfProducts prods = application.getProducts();
            if (prods.getProducts().containsKey(args))
            {
                throw new KeyException();
            }
            if(args == null || args.isEmpty()){
                throw new Exception();
            }
        prod.enterProd();
        prods.add(args, prod);
        application.setProducts(prods);
        ;}
        catch (KeyException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Неверный формат ключа");
        }

    }
}
