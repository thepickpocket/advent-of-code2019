package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String STOP = "99";

    private static List<String> test1 = new ArrayList<String>(Arrays.asList("3", "21", "1008", "21", "8", "20", "1005", "20", "22", "107", "8", "21", "20", "1006", "20", "31",
            "1106", "0", "36", "98", "0", "0", "1002", "21", "125", "20", "4", "20", "1105", "1", "46", "104",
            "999", "1105", "1", "46", "1101", "1000", "1", "20", "4", "20", "1105", "1", "46", "98", "99"));

    public static void main(String[] args) throws Exception {
        readInputFile();
        int position = 0;
        while (!test1.get(position).equals(STOP)) {
            String currentSet = test1.get(position);
            List<Integer> parameterModes = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
            Character optCode = currentSet.charAt(0);
            if (currentSet.length() >= 3) {
                optCode = currentSet.charAt(currentSet.length() - 1);
                int count = 0;
                for (int i = currentSet.length() - 3; i >= 0; i--) {
                    parameterModes.set(count, Integer.parseInt(currentSet.charAt(i) + ""));
                    count++;
                }
            }

            switch (optCode) {
                case '1': {
                    Integer param1 = getParam1(position, parameterModes, 0);
                    Integer param2 = getParam1(position, parameterModes, 1);
                    Integer result = param1 + param2;
                    Integer resultPos = Integer.valueOf(test1.get(position + 3));

                    test1.set(resultPos, result.toString());
                    position += 4;
                    break;
                }
                case '2': {
                    Integer param1 = getParam1(position, parameterModes, 0);
                    Integer param2 = getParam1(position, parameterModes, 1);
                    Integer result = param1 * param2;
                    Integer resultPos = Integer.valueOf(test1.get(position + 3));

                    test1.set(resultPos, result.toString());
                    position += 4;
                    break;
                }
                case '3': {
                    System.out.print("Please enter a value: ");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.next();
                    Integer resultPos = Integer.valueOf(test1.get(position + 1));

                    test1.set(resultPos, input);
                    position += 2;
                    break;
                }
                case '4': {
                    Integer resultPos = Integer.valueOf(test1.get(position + 1));
                    System.out.println("value at " + resultPos + ": " + test1.get(resultPos));
                    position += 2;
                    break;
                }
                case '5': {
                    Integer value = getParam1(position, parameterModes, 0);
                    if (value != 0) {
                        position = getParam1(position, parameterModes, 1);
                        break;
                    }
                    position += 3;
                    break;
                }
                case '6': {
                    Integer value = getParam1(position, parameterModes, 0);
                    if (value == 0) {
                        position = getParam1(position, parameterModes, 1);
                        break;
                    }
                    position += 3;
                    break;
                }
                case '7': {
                    Integer param1 = getParam1(position, parameterModes, 0);
                    Integer param2 = getParam1(position, parameterModes, 1);
                    Integer param3 = Integer.valueOf(test1.get(position + 3));

                    if (param1 < param2) {
                        test1.set(param3, "1");
                    } else {
                        test1.set(param3, "0");
                    }

                    position += 4;
                    break;
                }
                case '8': {
                    Integer param1 = getParam1(position, parameterModes, 0);
                    Integer param2 = getParam1(position, parameterModes, 1);
                    Integer param3 = Integer.valueOf(test1.get(position + 3));

                    if (param1.equals(param2)) {
                        test1.set(param3, "1");
                    } else {
                        test1.set(param3, "0");
                    }

                    position += 4;
                    break;
                }
            }
        }

        System.out.println("Array: " + test1);
    }

    private static Integer getParam1(int position, List<Integer> parameterModes, int i) {
        return parameterModes.get(i) == 0 ? Integer.valueOf(test1.get(Integer.valueOf(test1.get(position + i + 1)))) : Integer.valueOf(test1.get(position + i + 1));
    }

    private static void readInputFile() throws Exception {
        test1 = new ArrayList<String>();
        File file = new File("/Users/jason/Desktop/advent-of-code2019/Day5/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            test1.addAll(Arrays.asList(st.split(",")));
        }
    }
}
