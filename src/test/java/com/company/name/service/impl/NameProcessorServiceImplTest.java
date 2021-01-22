package com.company.name.service.impl;

import com.company.name.model.Name;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NameProcessorServiceImplTest {
    private NameProcessorServiceImpl classToTest;
    private List<String> nameList;

    @Before
    public void setUp() throws Exception {
        classToTest = new NameProcessorServiceImpl();
        nameList = Arrays.asList("MARY", "PATRICIA", "LINDA", "BARBARA");
    }

    @Test
    public void processData() {
        List<Name> names = classToTest.processData(nameList);
        assertEquals(names.get(0).getName(), "BARBARA");
        assertEquals(names.get(0).getSum(), 43);

        assertEquals(names.get(3).getName(), "PATRICIA");
        assertEquals(names.get(3).getSum(), 308);
    }
}