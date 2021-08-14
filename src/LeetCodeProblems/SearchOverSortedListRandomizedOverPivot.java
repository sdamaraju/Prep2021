package LeetCodeProblems;

public class SearchOverSortedListRandomizedOverPivot {

    public static void main(String[] args) {
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 0));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 1));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 2));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 3));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 4));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 5));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 6));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 7));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 8));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2}, 9));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 0));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 1));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 2));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 3));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 4));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 5));
        System.out.println(getIndexOfSortedListRandomizedOverPivot(new int[]{5, 6, 0, 1, 2, 3, 4}, 6));
    }

    public static int getIndexOfSortedListRandomizedOverPivot(int arr[], int target) {
        int min = 0;
        int index = findIndex(arr, min, arr.length - 1, target);
        return index;
    }

    public static int findIndex(int[] arr, int min, int max, int target) {
        if (max - min == 1) return arr[max] == target ? max : arr[min] == target ? min : -1;
        int mid = (min + max) / 2;
        if (arr[mid] == target) return mid;
        if (arr[min] <= arr[mid - 1] && (target >= arr[min] && target <= arr[mid - 1])) {
            return binarySearch(arr, min, mid - 1, target);
        } else if (arr[min] <= arr[mid - 1]) {
            return findIndex(arr, mid + 1, max, target);
        } else if (arr[mid + 1] <= arr[max] && (target >= arr[mid + 1] && target <= arr[max])) {
            return binarySearch(arr, mid + 1, max, target);
        } else if (arr[mid + 1] <= arr[max]) {
            return findIndex(arr, min, mid - 1, target);
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int min, int max, int target) {
        int mid = (min + max) / 2;
        if (arr[mid] == target) return mid;
        if (min > max || min >= arr.length - 1) return -1;
        else if (arr[mid] > target) {
            max = mid - 1;
        } else min = mid + 1;
        return binarySearch(arr, min, max, target);
    }
}
