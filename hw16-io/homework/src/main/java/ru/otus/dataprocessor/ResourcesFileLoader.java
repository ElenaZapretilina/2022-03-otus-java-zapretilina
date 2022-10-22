package ru.otus.dataprocessor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.otus.model.Measurement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ResourcesFileLoader implements Loader {
    private String fileName;
    private final ObjectMapper mapper = new ObjectMapper();


    public ResourcesFileLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        var gson = new Gson();
        var is = ResourcesFileLoader.class.getClassLoader().getResourceAsStream(fileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Measurement[] result = new Measurement[0];
        try {
            result = gson.fromJson(reader.readLine(), Measurement[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return List.of(result);
    }
}
