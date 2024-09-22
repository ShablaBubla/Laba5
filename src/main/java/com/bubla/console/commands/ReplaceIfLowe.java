package com.bubla.console.commands;

import com.bubla.classes.Product;
import com.bubla.console.exceptions.KeyException;
import com.bubla.console.executer.Application;

public class ReplaceIfLowe extends PrimeCommand<String> {
    public ReplaceIfLowe(){super("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");}

    @Override
    public void execute(String args, Application application) {
        try{
            Product prod;
            Insert insert = new Insert();
            if(application.getInputStream().getClass().getCanonicalName().equals("java.io.FileInputStream")){
                prod = insert.enterProductFromFile(application.getScanner());
            }
            else {
                prod = insert.enterProduct();
            }
            prod.increaseID();
        if(prod.compareTo(application.getProducts().getProducts().get(args)) > 0){
            application.getProducts().update(args, prod);
        }}
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неверный формат ввода данных из файла");
        }
        catch (Exception e){
            System.out.println("Нет продукта с таким ключом");
        }
    }
}
