package LeetCodeProblems;

import java.util.ArrayList;
import java.util.Comparator;

public class ZeroesAndOnes {

    private static class CustomObject {
        int first;
        int second;

        @Override
        public String toString() {
            return "{" +
                     first + "," +
                     second +
                    '}';
        }

        CustomObject(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        String arr[] = new String[]{"10", "0001", "111001", "1", "0"};
        int z = 5;
        int o = 3;
        /*String arr[] = new String[]{"10","0","1"};
        int z = 1;
        int o = 1;*/
        /*String arr[] = new String[]{"10", "0", "1"};
        int z = 0;
        int o = 0;*/

        /*String arr[] = new String[]{"00011", "011", "101", "10"};
        int z = 3;
        int o = 3;*/
        System.out.println(getLargestSubsetCount(arr, z, o));
    }

    private static int getLargestSubsetCount(String[] arr, int z, int o) {
        int zero[] = new int[arr.length];
        int one[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) == '0') {
                    zero[i]++;
                } else {
                    one[i]++;
                }
            }
        }
        ArrayList<CustomObject> listOfCustomobjects = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (zero[i] > z || one[i] > o) continue;
            listOfCustomobjects.add(new CustomObject(zero[i], one[i]));
        }
        System.out.println(listOfCustomobjects);
        int zeroCount = evaluateCumulativeCount(listOfCustomobjects, z, o, true);
        int oneCount = evaluateCumulativeCount(listOfCustomobjects, o, z, false);
        return Math.min(zeroCount, oneCount);
    }

    private static int evaluateCumulativeCount(ArrayList<CustomObject> listOfCustomobjects, int primaryThreshold, int secondaryThreshold, boolean zeros) {
        int primarySum = 0;
        int secondarySum = 0;
        if (primaryThreshold <= primarySum || secondaryThreshold <= secondarySum) return 0;
        int count = 0;
        listOfCustomobjects.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return zeros ? ((CustomObject) o1).first == ((CustomObject) o2).first ? ((CustomObject) o1).second - ((CustomObject) o2).second : ((CustomObject) o1).first - ((CustomObject) o2).first :
                        ((CustomObject) o1).second == ((CustomObject) o2).second ? ((CustomObject) o1).first - ((CustomObject) o2).first : ((CustomObject) o1).second - ((CustomObject) o2).second;
            }
        });

        System.out.println(listOfCustomobjects);
        for (int i = 0; i < listOfCustomobjects.size(); i++) {
            CustomObject obj = listOfCustomobjects.get(i);
            primarySum = zeros ? primarySum + obj.first : primarySum + obj.second;
            secondarySum = zeros ? secondarySum + obj.second : secondarySum + obj.first;
            if (primarySum <= primaryThreshold && secondarySum <= secondaryThreshold) count++;
            else break;
        }
        return count;
    }

}
