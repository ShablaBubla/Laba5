package com.bubla.console.file_managment;

import com.bubla.classes.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

@Data
public class Write {
    private LinkedHashMap<String, Product> values;
    private String file;

    public Write(LinkedHashMap<String, Product> products, String file){
        this.file = file;
        this.values = products;
    }

    public void record() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.registerModule(new JavaTimeModule());
            xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            String xml = xmlMapper.writeValueAsString(this.values);
            try (BufferedOutputStream buff = new BufferedOutputStream(new FileOutputStream(this.file))) {
                buff.write(xml.getBytes(StandardCharsets.UTF_8));
                buff.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Переменной FILE_PATH не существует");
            }
        }catch (JsonProcessingException e){
            System.out.println("Не получится запарсить");
        }
    }
}
