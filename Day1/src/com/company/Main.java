package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Integer> values;

    public static void main(String[] args) throws Exception {
        readValues();
        Integer sumOfFeulRequirments = values.stream().reduce(0, (subtotal, value) ->
            subtotal + calculateFuel(value)
        );

        System.out.println("Sum of fuel required: " + sumOfFeulRequirments);
    }

    private static Integer calculateFuel(Integer mass) {
        Integer fuel = Math.floorDiv(mass, 3) - 2;
        if (fuel > 0) {
            return (fuel) + calculateFuel(fuel);
        }

        return 0;
    }

    private static void readValues() throws Exception {
        values = new ArrayList<Integer>();
        File file = new File("/Users/jason/Desktop/advent-of-code2019/Day1/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            values.add(Integer.valueOf(st));
        }
    }
}
