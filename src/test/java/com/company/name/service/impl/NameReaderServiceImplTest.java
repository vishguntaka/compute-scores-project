package com.company.name.service.impl;

import com.company.name.service.NameReaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
public class NameReaderServiceImplTest {

    @Autowired
    private NameReaderService classToTest;

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public NameReaderService nameReaderService() {
            return new NameReaderServiceImpl();
        }
    }

    @Test
    public void getNames() throws IOException {
        List<String> names = classToTest.getNames("/names.txt");
    }
}