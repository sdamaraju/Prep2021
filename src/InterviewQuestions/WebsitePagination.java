package InterviewQuestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebsitePagination {

    public static void main(String[] args) {
        ArrayList<ArrayList> items = new ArrayList();
        ArrayList<String> item1 = new ArrayList();
        ArrayList<String> item2 = new ArrayList();
        ArrayList<String> item3 = new ArrayList();
        item1.add("abc");item1.add("3");item1.add("1");
        item2.add("bc");item2.add("2");item2.add("2");
        item3.add("ca");item3.add("1");item3.add("3");
        items.add(item1);
        items.add(item2);
        items.add(item3);
        System.out.println(fetchItemsToDisplay(items, 1, 0, 2, 1));
    }

    private static List<String> fetchItemsToDisplay(ArrayList<ArrayList> items, int sortOrder, int sortParameter, int itemsPerPage, int pageNumber) {
        if (sortParameter == 0) {
            items.sort(new Comparator<ArrayList>() {
                @Override
                public int compare(ArrayList o1, ArrayList o2) {
                    if (sortOrder == 0) return ((String) o1.get(0)).compareTo((String) o2.get(0));
                    else return ((String) o2.get(0)).compareTo((String) o1.get(0));
                }
            });
        } else {
            items.sort(new Comparator<ArrayList>() {
                @Override
                public int compare(ArrayList o1, ArrayList o2) {
                    if (sortOrder == 0) return (Integer.parseInt((String)o1.get(sortParameter))) - Integer.parseInt((String)o2.get(sortParameter));
                    else return (Integer.parseInt((String)o2.get(sortParameter))) - Integer.parseInt((String)o1.get(sortParameter));

                }
            });
        }
        ArrayList<String> results = new ArrayList<>();
        //System.out.println(items);
        for (int i = itemsPerPage * pageNumber; i < itemsPerPage * pageNumber + itemsPerPage; i++) {
            if(i >= items.size()) return results;
            results.add((String) items.get(i).get(0));
        }
        return results;
    }

}
