package com.company.name.service.impl;

import com.company.name.enums.Department;
import com.company.name.model.Name;
import com.company.name.service.NameProcessorService;
import com.company.name.service.NameReaderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class DEP1ComputeNameScoreServiceImplTest {
    public static final String[] ARGS = {"C:\\Users\\names.txt.txt", "DEP1"};

    @Mock
    private NameProcessorService nameProcessorService;

    @Mock
    private NameReaderService nameReaderService;

    @InjectMocks
    private DEP1ComputeNameScoreServiceImpl classTotest;
    private List<String> nameList;
    private List<Name> names;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        nameList = Arrays.asList("MARY", "PATRICIA", "LINDA", "BARBARA");
        Collections.sort(nameList);

        names = new ArrayList<>();
        nameList.stream().forEach(s -> names.add(new Name(s, nameList.indexOf(s) + 1)));

    }

    @Test
    public void computeNameScore() throws Exception {
        when(nameReaderService.getNames(ARGS[0])).thenReturn(nameList);

        when(nameProcessorService.processData(nameList)).thenReturn(names);

        Assert.assertEquals(602, classTotest.computeNameScore(ARGS));
    }

    @Test
    public void getDepartmentId() {
        Assert.assertEquals(Department.DEP1.name(), classTotest.getDepartmentId());
    }
}