public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = {10, 20, 25, 40, 60};
        int key = 61; // should return true
        //int notToFind = 35; // return false
        System.out.println(binarySearch(ints,key));
    }

    static int binarySearch (int [] ints, int key){
        int min = 0;
        int max = ints.length-1;
        while(max >= min){
            int mid = (min + max) / 2;
            if(ints[mid] == key) return mid;
            else if (ints[mid] > key){
                max = mid-1;
            }
            else {
                min = mid+1;
            }
            System.out.println(min+ "," + mid + "," + max);
        }
        return -1;
    }

}
