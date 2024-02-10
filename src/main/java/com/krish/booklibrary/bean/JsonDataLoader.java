package com.krish.booklibrary.bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krish.booklibrary.model.Book;
import com.krish.booklibrary.model.Data;
import com.krish.booklibrary.model.User;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonDataLoader {
    @Bean
    public Data loadBooksFromJson() {
        Data data = new Data();

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        File file = new File("src/main/resources/data/data.json");
        try {
            data= mapper.readValue(file, new TypeReference<>() {});
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


}
