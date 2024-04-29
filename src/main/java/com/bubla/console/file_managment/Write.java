package com.bubla.console.file_managment;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Write {
    private List<Product> values;

    public Write(LinkedHashMap<String, Product> productsMap){
        this.values = new ArrayList<>(productsMap.values());
    }

    public void record(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(file, this.values);
    }
}
