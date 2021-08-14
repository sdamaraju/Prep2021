package InterviewQuestions;

import java.util.HashMap;

public class MaxProfit {
    static int roseCost  = 2;
    static int lillyCost  = 3;
    static HashMap map = new java.util.HashMap();
    public static void main(String[] args) {
        int values[] = new int[]{0,0,1,1,1,0,0};
        System.out.println(recurse(values,0));
    }

    private static int recurse(int [] values, int index){
        if(index+1 >= values.length) return 0;
        if(map.get(index) != null) return (Integer)map.get(index);
        int f = recurse(values, index+1);
        int rose=0;
        int lily = 0;
        if(makerose(values, index)) {
            rose += roseCost + recurse(values,index+3);
        }
        if(makelily(values, index)) {
            lily += lillyCost + recurse(values,index+2);;
        }
        int result = Math.max(rose,Math.max(f,lily));
        map.put(index,result);
        return result;
    }

    private static boolean makerose(int[] values, int index) {
        if (index + 2 >= values.length) return false;
        if (values[index] == 0 && values[index+1] == 0 && values[index+2] == 0) return true;
        return false;
    }
    private static boolean makelily(int[] values, int index) {
        if (index + 1 >= values.length) return false;
        if ((values[index] == 0 && values[index+1] == 1) ||( values[index] == 1 && values[index+1] == 0)) return true;
        return false;
    }
}
