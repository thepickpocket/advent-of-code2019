package za.co.jasonevans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main {
    // Assumptions
    // 1. Starting position is on (0,0)

    private static List<String> wires = new ArrayList<>();
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        wires.addAll(Arrays.asList("R75,D30,R83,U83,L12,D49,R71,U7,L72"));
        wires.addAll(Arrays.asList("U62,R66,U55,R34,D71,R55,D58,R83"));

        traceWireSteps();

    }

    private static void traceWireSteps() {
        for (String wire: wires) {
            String[] steps = wire.split(",");
            Integer x = 0;
            Integer y = 0;
            Integer stepsTaken = 0;

            // we always start at (0,0)
            map.put(getMapCoordinate(x, y), 1);

            for (String step: steps) {
                Character action = step.charAt(0);
                Integer distance = Integer.parseInt(step.substring(1));

                for (int i = 0; i < distance; i++) {
                    stepsTaken++;
                    String key = getMapCoordinate(x, y);

                    if (map.containsKey(key)) {
                        Integer currentCount = map.get(key);
                        map.put(getMapCoordinate(x, y), currentCount + 1);
                    }

                    switch (action) {
                        case 'U': {
                            y++;
                            break;
                        }
                        case 'D': {
                            y--;
                            break;
                        }
                        case 'L': {
                            x--;
                            break;
                        }
                        case 'R': {
                            x++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Smallest Distance: " + getSmallestDistance());
    }

    private static String getMapCoordinate(Integer x, Integer y) {
        return "(" + x + "," + y + ")";
    }

    private static Integer getSmallestDistance() {
        Integer distance = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> mapEntry: map.entrySet()) {
            Integer x = getXFromKey(mapEntry.getKey());
            Integer y = getYFromKey(mapEntry.getKey());

            if (mapEntry.getValue() >= 2) {
                Integer calculatedDistance = Math.abs(x) + Math.abs(y);
                distance = calculatedDistance > 0 ? Math.min(distance, Math.abs(x) + Math.abs(y)): distance;
            }
        }

        return distance;
    }

    private static Integer getXFromKey(String key) {
        return Integer.parseInt(key.substring(1, key.indexOf(',')));
    }

    private static Integer getYFromKey(String key) {
        return Integer.parseInt(key.substring(key.indexOf(',') + 1, key.indexOf(')')));
    }

    private static void readValues() throws Exception {
        wires = new ArrayList<String>();

        File file = new File("/Users/jason/Desktop/advent-of-code2019/Day3/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            wires.add(st);
        }

        br.close();
    }
}
