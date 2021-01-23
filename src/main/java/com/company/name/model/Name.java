package com.company.name.model;


public class Name {
    private String name;
    private long index;
    private long sum;


    private static String alphabets = "abcdefghijklmnopqrstuvwxyz";

    public Name(String name, long index) {
        this.name = name;
        this.index = index;
        this.sum = calculateSum(name);
    }

    public long calculateSum(String name) {
        name.chars().forEach(value -> {
            //skip if value is empty
            if (value != ' ') {

                int charIndex = alphabets.indexOf(value);

                //check if the given value is uppercase
                if (charIndex < 0) {
                    charIndex = alphabets.toUpperCase().indexOf(value);
                }

                this.sum = this.sum + charIndex + 1;
            }
        });

        return this.sum * index;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
