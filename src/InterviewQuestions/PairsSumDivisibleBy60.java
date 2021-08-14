package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class PairsSumDivisibleBy60 {

    public static int main(String[] args) {
        int [] listOfSongs = new int[] {60,60,60};

        /*listOfSongs.add(60);
        listOfSongs.add(60);
        listOfSongs.add(60);
        listOfSongs.add(10);
        listOfSongs.add(30);
        listOfSongs.add(150);
        listOfSongs.add(60);
        listOfSongs.add(50);
        listOfSongs.add(70);*/

        for (int i = 0; i < listOfSongs.length; i++) {
            int value = listOfSongs[i];
            if (value % 60 == 0) {
                listOfSongs[i] = 60;
            } else {
                listOfSongs[i] = value % 60;
            }
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < listOfSongs.length; i++) {
            int value = listOfSongs[i];
            Integer mapVal = map.get(value);
            if (value == 60 || value == 30) {
                map.put(value, mapVal == null ? 1 : mapVal+1);
            } else {
                if (mapVal != null)
                    map.put(value, mapVal + 1);
                else map.put(value,1);
            }
        }
      //  System.out.println(map);
        int totalPairs = 0;
        int tempCounter2 = 0 ;
        boolean checked30 = false;
        boolean checked60 = false;
        for (int i = 0; i < listOfSongs.length; i++) {
            int value = listOfSongs[i];
            if ((value == 60)|| (value == 30)) {
                if (value == 60 && !checked60) checked60 = true;
                else if (value == 30 && !checked30) checked30 = true;
                else continue;
                int tempCounter1 = map.get(value);
                tempCounter1 = (tempCounter1 * (tempCounter1 - 1)) / 2;
                totalPairs = totalPairs + tempCounter1;
            } else {
               // System.out.println(listOfSongs[i] + " " + map.get(60 - listOfSongs[i]));
                Integer mapVal = map.get(60 - value);
                tempCounter2 = tempCounter2 + (mapVal != null ? mapVal : 0);
            }
        }
        totalPairs = totalPairs + tempCounter2/2 ;
        return totalPairs;
           // System.out.println(totalPairs);
    }
}
