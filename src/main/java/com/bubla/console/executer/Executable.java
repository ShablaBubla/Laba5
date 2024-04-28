package com.bubla.console.executer;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;

public interface Executable<T>{
    void execute(T args, Application application);
}
