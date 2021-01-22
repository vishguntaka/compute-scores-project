package com.company.name.service.impl;

import com.company.name.enums.Department;
import com.company.name.service.ComputeNameScoreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ComputeNameScoreServiceImplTest {

    public static final String[] ARGS = {"C:\\Users\\names.txt.txt", "DEP1"};

    private ComputeNameScoreServiceImpl classToTest;

    @Mock
    private ComputeNameScoreService computeNameScoreService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        when(computeNameScoreService.getDepartmentId()).thenReturn(Department.DEP1.name());
        classToTest = new ComputeNameScoreServiceImpl(Arrays.asList(computeNameScoreService));

    }

    @Test
    public void computeNameScore() throws Exception {
        classToTest.computeNameScore(ARGS);

        verify(computeNameScoreService, times(1)).computeNameScore(ARGS);
    }
}