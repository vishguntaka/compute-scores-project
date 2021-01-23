package com.company.name.service.impl;

import com.company.name.service.ComputeNameScoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ComputeNameScoreServiceImpl.class,
        DEP1ComputeNameScoreServiceImpl.class,
        NameProcessorServiceImpl.class,
        NameReaderServiceImpl.class})
public class ComputeNameScoreServiceImplTest {

    public static final String[] ARGS = {"names.txt"};


    @Resource(name = "computeNameScoreServiceDelegator")
    private ComputeNameScoreService computeNameScoreServiceImpl;


    @Test
    public void computeNameScore() throws Exception {
        long result = computeNameScoreServiceImpl.computeNameScore(ARGS);

        Assert.assertEquals(871198282, result);

    }
}