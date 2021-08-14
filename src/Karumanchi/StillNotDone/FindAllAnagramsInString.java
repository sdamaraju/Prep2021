package Karumanchi.StillNotDone;

import java.util.ArrayList;
import java.util.HashMap;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        ArrayList op = findAllAnagramsInString(s, p);
        System.out.println(op);
    }

    private static ArrayList findAllAnagramsInString(String s, String p) {
        ArrayList<Integer> result = new ArrayList();
        HashMap<Character, Integer> charCount = new HashMap();
        HashMap<Character, Integer> checker = new HashMap();
        for (int i = 0; i < p.length(); i++) {
            if (charCount.get(p.charAt(i)) == null) {
                charCount.put(p.charAt(i), 1);
            } else charCount.put(p.charAt(i), charCount.get(p.charAt(i)) + 1);
        }
        int k = 0;
        int slowPointer = 0;
        int fastPointer = 0;
        char prev = ' ';
        char character = ' ';
        while (fastPointer <= s.length()) {
            if (k < p.length()) {
                if (fastPointer == s.length()) break;
                character = s.charAt(fastPointer);
                System.out.print(character);
                System.out.print(slowPointer);
                System.out.print(fastPointer);
                System.out.print(k);
                System.out.println(checker);
                System.out.println();
                Integer charCounter = charCount.get(character);
                if (charCounter != null) {
                    int checkCounter = checker.get(character) == null ? 0 : checker.get(character);
                    if (checkCounter < charCounter) {
                        checker.put(character, checkCounter + 1);
                        k++;
                    } else {
                        if(prev == character) {
                            slowPointer=fastPointer;
                            checker = new HashMap<>();
                            k=0;
                            continue;
                        }else {
                            slowPointer++;
                            k--;
                            checker.put(character,checker.get(character)-1);
                            continue;
                        }
                    }
                } else {
                    slowPointer = fastPointer + 1;
                    k = 0;
                    checker = new HashMap();
                }
            } else {
                result.add(slowPointer);
                System.out.println("got 1 result" + result);
                char charAtSlowPointer = s.charAt(slowPointer);
                checker.put(charAtSlowPointer, checker.get(charAtSlowPointer) - 1);
                slowPointer++;
                k--;
                fastPointer--;
            }
            prev = character;
            fastPointer++;
        }
        return result;
    }

}
