package LeetCodeProblems;

import java.util.HashSet;

public class StringsAlike {

    static HashSet vowels;
    public static void main(String[] args) {
        //String input = "textbook";
        //String input = "book";
        //String input = "MerryChristmas";
        String input = "AbCdEfGh";
        init();
        System.out.println(areStringsAlike(input.substring(0, input.length() / 2), input.substring(input.length() / 2)));
    }

    private static void init() {
        vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    private static boolean areStringsAlike(String substring1, String substring2) {
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < substring1.length(); i++) {
            if(vowels.contains(substring1.charAt(i))){
                v1++;
            }
            if(vowels.contains(substring2.charAt(i))){
                v2++;
            }
        }
        return v1 == v2;
    }

}
