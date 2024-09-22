package com.bubla.console.commands;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.bubla.console.executer.Application;


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
                break;
            }
        }
        try{
            Product newProduct;
            Insert insert = new Insert();
            if(application.getInputStream().getClass().getCanonicalName().equals("java.io.FileInputStream")){
                newProduct = insert.enterProductFromFile(application.getScanner());
            }
            else {
                newProduct = insert.enterProduct();
            }
            newProduct.setId(id);
            prods.update(oldKey, newProduct);
        }catch(NullPointerException e){
            System.out.println("Объект с таким id не существует");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неверный формат ввода данных из файла");
        }
    }
}
