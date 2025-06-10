import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        int n = arr.length;
        System.out.println("Before Insertion Sort");
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    Swap.swap(arr, j, j - 1);
                } else
                    break;
                j--;
            }
        }

        System.out.println("After Insertion Sort");
        System.out.println(Arrays.toString(arr));
    }
}
