import java.util.*;

public class PractisePHNToString{
    private static List<String> combinations = new ArrayList<>();
    private static HashMap<Integer, Integer> map = new HashMap();

    private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private static String digits = "345";
    public static void main(String[] args) {
        recurse(0,new StringBuilder());
        int coins[] = new int[]{186, 419, 83, 408};
        //int coins[] = new int[]{1, 2, 4, 5};
        int target = 6249;
        Arrays.sort(coins);
        coinChangeRecurse(coins,target);
        System.out.println(map.get(target));
        System.out.println(combinations);
    }

    private static void recurse(int index, StringBuilder path){
        if(path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }
        String relevantChars = letters.get(digits.charAt(index));
        for(char eachChar : relevantChars.toCharArray()){
            path.append(eachChar);
            recurse(index+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }

    public static int coinChangeRecurse(int coins[], int target){
        if(map.get(target)!=null)return map.get(target);
        if(target == 0) return 0;
        Integer temp = Integer.MAX_VALUE;
        for(int coin : coins){
            if(target-coin >= 0){
                temp = Math.min(temp, coinChangeRecurse(coins,target-coin));
            }
        }
        map.put(target,temp != Integer.MAX_VALUE ? temp + 1 : temp);
        return map.get(target);
    }



}
