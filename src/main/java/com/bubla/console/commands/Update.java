package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;
import com.sun.jdi.LongValue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Update extends PrimeCommand<String>{
    public Update(){super("update id {element} : обновить значение элемента коллекции, id которого равен заданному");}

    public void execute(String args, Application application){
        long id = Long.parseLong(args);
        LinkedHashMapOfProducts prods = application.getProducts();
        String oldKey = null;
        for (String key: prods.getProducts().keySet()){
            Product product = prods.getProducts().get(key);
            if(id == product.getId()){
                oldKey = key;
            }
        }
        try{
            Product newProduct = new Product();
            newProduct.enterProd();
            prods.update(oldKey, newProduct);
        }catch(NullPointerException e){
            System.out.println("Объект с таким id не существует");
        }
    }
}
