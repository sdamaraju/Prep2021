package LeetCodeProblems;

import java.util.HashMap;

public class AlienDictionaryValidator {

    public static void main(String[] args) {
        /*["word","world","row"]
        "worldabcefghijkmnpqstuvxyz"*/
        AlienDictionaryValidator obj = new AlienDictionaryValidator();
        //obj.initLanguage("worldabcefghijkmnpqstuvxyz");
        System.out.println(obj.isAlienSorted(new String[]{"hello", "hello"},"abcdefghijklmnopqstuvxyz"));
    }

    private HashMap initLanguage(String order) {
        HashMap charOrder = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) {
            charOrder.put(order.charAt(i), i + 1);
        }
        return charOrder;
    }

    private boolean isAlienSorted(String[] strings, String order) {
        HashMap<Character, Integer> charOrder = initLanguage(order);
        boolean isValid = true;
        for (int i = 0; i < strings.length - 1; i++) {
            isValid = validate(strings[i], strings[i + 1], charOrder);
            if (!isValid) return false;
        }
        return true;
    }

    private boolean validate(String string1, String string2, HashMap<Character,Integer> charOrder) {
        int str1Length = string1.length();
        int str2Length = string2.length();
        if (str1Length == 0 && str2Length >= 0) return true;
        if (str1Length >= 0 && str2Length == 0) return false;
        int j = 0;
        int i = 0;
        int currChar1, currChar2;
        while (i < str1Length && j < str2Length) {
            //if(charOrder.get(string1.charAt(i)) == null || charOrder.get(string2.charAt(j)) == null) return false;
            currChar1 = charOrder.get(string1.charAt(i++));
            currChar2 = charOrder.get(string2.charAt(j++));
           // if ((Integer)currChar1 == null || (Integer)currChar2 == null) return false;
            if (currChar1 > currChar2) return false;
            if (currChar1 < currChar2) return true;
        }
        if (str1Length > str2Length) return false;
        return true;
    }

    // Need to discuss on this..

    /*private static boolean validator(String[] strings) {
        boolean[] accuratelyPlaced = new boolean[strings.length];
        for (int i = 0; i < strings.length; i++) accuratelyPlaced[i] = false;
        for (int i = 0; i < Integer.MAX_VALUE; i++) { //index
            int[] checkCharactersAtIndex = new int[strings.length];
            for (int j = 0; j < strings.length; j++) { // each string
                if (strings[j].length() >= i + 1) {
                    checkCharactersAtIndex[i] = charOrder.get(strings[j].charAt(i));
                } else if (strings[j].length() == 0) checkCharactersAtIndex[i] = Integer.MIN_VALUE;
                else checkCharactersAtIndex[i] = -1;
            }
            validate(checkCharactersAtIndex);
        }
    }

    private static boolean validate(int[] values) {
        boolean isValid = true;
        for (int i = 0; i < values.length - 1; i++) {

            if (values[i] <= values[i + 1]) {

            }
        }
        return isValid;
    }*/

}
