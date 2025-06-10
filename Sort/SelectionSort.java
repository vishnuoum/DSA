import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        int n = arr.length;
        System.out.println("Before Selection Sort");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            Swap.swap(arr, i, min_index);
        }

        System.out.println("After Selection Sort");
        System.out.println(Arrays.toString(arr));
    }
}
