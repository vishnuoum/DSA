import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        System.out.println("Before Bubble Sort");
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Swap.swap(arr, j, j + 1);
                }
            }
        }
        System.out.println("After Bubble Sort");
        System.out.println(Arrays.toString(arr));
    }
}