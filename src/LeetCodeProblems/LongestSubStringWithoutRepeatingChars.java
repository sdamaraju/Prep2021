package LeetCodeProblems;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        String question = "anviaj"; //"abcddefghth" "dvdf" "anviaj"
        System.out.println(findLongestSubStringWithoutRepeatingChars(question));
        System.out.println(findLongestSubStringWithoutRepeatingChars_slidingWindowApproach(question));
    }

    private static int findLongestSubStringWithoutRepeatingChars(String str) {
        if (str.equals("")) return 1;
        HashMap mapOfCharacters = new HashMap();
        int maxNonRepeatSubStrLength = 1;
        int tempMaxNonRepeatCheck = 0;
        for (int i = 0; i < str.length(); i++) {
            if (mapOfCharacters.get(str.charAt(i)) == null) {
                tempMaxNonRepeatCheck++;
                mapOfCharacters.put(str.charAt(i), i);
            } else {
                int previousIndexOfCurrentChar = (int) mapOfCharacters.get(str.charAt(i));
                if (maxNonRepeatSubStrLength <= tempMaxNonRepeatCheck) {
                    maxNonRepeatSubStrLength = tempMaxNonRepeatCheck;
                }
                mapOfCharacters = new HashMap();
                int counter = 0;
                for (int j = previousIndexOfCurrentChar + 1; j <= i; j++) {
                    mapOfCharacters.put(str.charAt(j), j);
                    counter++;
                }
                tempMaxNonRepeatCheck = counter;
                mapOfCharacters.put(str.charAt(i), i);
            }
        }
        if (maxNonRepeatSubStrLength <= tempMaxNonRepeatCheck) {
            maxNonRepeatSubStrLength = tempMaxNonRepeatCheck;
        }
        return maxNonRepeatSubStrLength;
    }

    private static int findLongestSubStringWithoutRepeatingChars_slidingWindowApproach(String str) {
        int startIndex = 0;
        int endIndex = -1;
        int maxNonRepeatSubStrLength = 0;
        HashSet set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                if (maxNonRepeatSubStrLength < endIndex - startIndex + 1) {
                    maxNonRepeatSubStrLength = endIndex - startIndex + 1;
                }
                int k = startIndex;
                for (int j = startIndex; j < endIndex; j++) {
                    if (str.charAt(j) == str.charAt(i)) {
                        break;
                    } else {
                        set.remove(str.charAt(j));
                        k++;
                    }
                }
                startIndex = k + 1;
                endIndex++;
            } else {
                set.add(str.charAt(i));
                endIndex++;
            }
        }
        if (maxNonRepeatSubStrLength < endIndex - startIndex + 1) {
            maxNonRepeatSubStrLength = endIndex - startIndex + 1;
        }
        return maxNonRepeatSubStrLength;
    }


}
