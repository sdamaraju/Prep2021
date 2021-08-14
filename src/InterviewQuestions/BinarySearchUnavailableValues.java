package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchUnavailableValues {

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList();

        x.add(2);
        x.add(3);

        x.add(5);
        x.add(6);
        x.add(7);
        x.add(8);
        System.out.println(search(0, x.size(), 4, x));
    }

    private static int search(int l, int r, Integer key, List<Integer> list) {
        if (l > r) return l - 1;
        int mid = (l + r) / 2;
        Integer midV = list.get(mid);
        if (midV == key) return -10;
        if (midV > key) {
            return search(l, mid - 1, key, list);
        } else return search(mid + 1, r, key, list);
    }

}
