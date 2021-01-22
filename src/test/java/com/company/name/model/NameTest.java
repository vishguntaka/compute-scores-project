package com.company.name.model;


import org.junit.Test;

public class NameTest {

    @Test
    public void testCalculateSum() {
        Name name = new Name("Johnson", 5);
        System.out.println(name.getSum());

    }
}