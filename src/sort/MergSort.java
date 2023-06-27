package sort;

public class MergSort {

    private static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, 0, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n = mid - low + 1;
        int m = high - mid;
        int[] left = new int[n];
        int[] right = new int[m];

        for (int i = 0; i < n; i++) {
            left[i] = array[low + i];
        }

        for (int j = 0; j < m; j++) {
            right[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < n && j < m) {
            if(left[i] <= right[j]){
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n){
            array[k] = left[i];
            i++;
            k++;
        }

        while(j < m){
            array[k] = right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[] { 4, 5, 7, 11, 10, 9, 2, 1 };
        mergeSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
