package za.co.jasonevans;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Integer LOWER_BOUND = 254032;
    private static final Integer UPPER_BOUND = 789860;

    public static void main(String[] args) {
//        getSection1();
        getSection2();
    }

    private static boolean validatePassword(Integer password, boolean singleDoubleDigits) {
        boolean ascending = true;
        String pass = password.toString();
        for (int i = 0; i < pass.length() - 1; i++) {
            Integer currentCharValue = Integer.parseInt(pass.substring(i, i + 1));
            Integer nextCharValue = Integer.parseInt(pass.substring(i + 1, i + 2));
            if (currentCharValue > nextCharValue) {
                ascending = false;
                break;
            }
        }

        //duplicates check
        boolean duplicateFound = false;
        if (!singleDoubleDigits) {
            for (int i = 0; i <= 9; i++) {
                if (pass.contains(i + "" + i)) {
                    duplicateFound = true;
                    break;
                }
            }
        } else {
            Map<Character, Integer> charsCounts = new HashMap<Character, Integer>();
            for (int i = 0; i < pass.length(); i++) {
                if (charsCounts.containsKey(pass.charAt(i))) {
                    charsCounts.put(pass.charAt(i), charsCounts.get(pass.charAt(i)) + 1);
                } else {
                    charsCounts.put(pass.charAt(i), 1);
                }
            }

            for (Map.Entry<Character, Integer> entry: charsCounts.entrySet()) {
                if (entry.getValue() == 2) {
                    duplicateFound = true;
                    break;
                }
                duplicateFound = false;
            }
        }

        return ascending && duplicateFound;
    }

    private static void getSection1() {
        Integer range = 0;
        Integer validPasswordCount = 0;
        Integer password = LOWER_BOUND;
        validPasswordCount = validatePassword(password, false) ? validPasswordCount + 1 : validPasswordCount;
        for (int i = LOWER_BOUND; i < UPPER_BOUND; i++) {
            password += 1;
            range++;
            validPasswordCount = validatePassword(password, false) ? validPasswordCount + 1 : validPasswordCount;
        }

        System.out.println("Valid Passwords: " + validPasswordCount);
        System.out.println("range: " + range);
    }

    private static void getSection2() {
        Integer validPasswordCount = 0;
        Integer password = LOWER_BOUND;
        validPasswordCount = validatePassword(password, true) ? validPasswordCount + 1 : validPasswordCount;
        for (int i = LOWER_BOUND; i < UPPER_BOUND; i++) {
            password += 1;
            validPasswordCount = validatePassword(password, true) ? validPasswordCount + 1 : validPasswordCount;
        }

        System.out.println("Valid Passwords: " + validPasswordCount);
    }
}
