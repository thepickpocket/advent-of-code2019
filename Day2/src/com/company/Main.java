package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String ADDITION = "1";
    private static final String MULTIPLICATION = "2";
    private static final String STOP = "99";

    private static Integer verb = 0;
    private static Integer noun = 0;

    private static List<String> test1;

    public static void main(String[] args) throws Exception {
        for (noun = 0; noun <= 99; noun++) {
            for (verb = 0; verb <= 99; verb++) {
                readInputFile();
                test1.set(1, verb.toString());
                test1.set(2, noun.toString());
                int position = 0;
                while (!test1.get(position).equals(STOP)) {
                    if (test1.get(position).equals(ADDITION)) {
                        Integer result = Integer.valueOf(test1.get(Integer.valueOf(test1.get(position + 1)))) + Integer.valueOf(test1.get(Integer.valueOf(test1.get(position + 2))));
                        Integer resultPos = Integer.valueOf(test1.get(position + 3));


                        test1.set(resultPos, result.toString());
                        position += 4;
                    } else if (test1.get(position).equals(MULTIPLICATION)) {
                        Integer result = Integer.valueOf(test1.get(Integer.valueOf(test1.get(position + 1)))) * Integer.valueOf(test1.get(Integer.valueOf(test1.get(position + 2))));
                        Integer resultPos = Integer.valueOf(test1.get(position + 3));


                        test1.set(resultPos, result.toString());
                        position += 4;
                    }
                }
                if (test1.get(0).equals("19690720")) {
                    System.out.println("List: " + test1);
                }
            }
        }
    }

    private static void readInputFile() throws Exception {
        test1 = new ArrayList<String>();
        File file = new File("/Users/jason/Desktop/Advent Of Code/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            test1.addAll(Arrays.asList(st.split(",")));
        }
    }
}
