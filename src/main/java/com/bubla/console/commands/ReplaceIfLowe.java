package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;

public class ReplaceIfLowe extends PrimeCommand<String> {
    public ReplaceIfLowe(){super("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");}

    @Override
    public void execute(String args, Application application) {
        try{Product prod = new Product();
        prod.enterProd();
        if(prod.compareTo(application.getProducts().getProducts().get(args)) > 0){
            application.getProducts().update(args, prod);
        };}
        catch (Exception e){
            System.out.println("Нет продукта с таким ключом");
        }
        finally {
            this.setApplication(application);
        }
    }
}
