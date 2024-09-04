package com.bubla.console.file_managment;

import com.bubla.classes.LinkedHashMapOfProducts;
import com.bubla.classes.Product;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Write {
    private LinkedHashMap<String, Product> values;

    public Write(LinkedHashMap<String, Product> products){
        this.values = products;
    }

    public void record(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        xmlMapper.writeValue(file, this.values);
    }
}
