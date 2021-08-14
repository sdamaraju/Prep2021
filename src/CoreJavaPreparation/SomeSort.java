package CoreJavaPreparation;

public class SomeSort {
    public static void main(String[] args) {
        int arr[] = {3,6,5,4,3,2,1,7,8,8};
        sort(arr);
        int arr2[] = {3,6,5,4,3,2,1,7,8,8};
        mergeSort(arr2,0,arr2.length-1);
        for (int i=0;i<arr2.length;i++) System.out.println(arr2[i]);
    }

    private static void sort(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            int min = arr[i];
            int temp = 0;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<min) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void mergeSort(int arr[], int l, int r){
        if(l < r){
            int m = (l + r)/2 ;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];
        for(int j=0;j<n2;j++)
            R[j]=arr[m+1+j];

         int i =0; int j=0;
         int k = l;
         while(i<n1 && j<n2){
             if(L[i] <= R[j]){
                 arr[k] = L[i];
                 i++;
             }else {
                 arr[k] = R[j];
                 j++;
             }
             k++;
         }
         while(i<n1){
             arr[k++]=L[i++];
         }
        while(j<n2){
            arr[k++]=R[j++];
        }
    }

}

