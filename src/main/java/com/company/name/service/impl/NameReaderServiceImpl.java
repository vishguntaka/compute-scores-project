package com.company.name.service.impl;

import com.company.name.service.NameReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class NameReaderServiceImpl implements NameReaderService {

    @Autowired
    private ResourceLoader resourceLoader;

    public List<String> getNames(String file) throws IOException {
        List namesList;
        StringBuilder result = new StringBuilder();
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(resourceLoader.getResource(file).getInputStream()), 20000)) {

            int value;
            while ((value = reader.read()) != -1) {
                if (value != 34) {
                    result.append((char) value);
                }
            }

            String[] nameArray = result.toString().split(",");

            namesList = Arrays.asList(nameArray);
        }
        return namesList;
    }
}
