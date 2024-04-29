package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Update extends PrimeCommand<String>{
    public Update(){super("update id {element} : обновить значение элемента коллекции, id которого равен заданному");}

    public void execute(String args, Application application){
        try {
            Product prod = new Product();
            prod.enterProd();
            LinkedHashMapOfProducts prods = application.getProducts();
            List<String> keys = new ArrayList<>(prods.getProducts().keySet());
            prods.update(keys.get(Integer.parseInt(args)), prod);
            application.setProducts(prods);
        } catch (Exception e){
            System.out.println("Продукта с таким id не существует");
        }
        finally {
            this.setApplication(application);
        }
    }
}
