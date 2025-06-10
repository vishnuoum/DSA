import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        int n = arr.length;
        System.out.println("Before Quick Sort");
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, n - 1);
        System.out.println("After Quick Sort");
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = pivot(arr, left, right);
            quicksort(arr, left, partition - 1);
            quicksort(arr, partition + 1, right);
        }
    }

    private static int pivot(int[] arr, int left, int right) {
        int high = right;
        right--;
        while (true) {
            while (left < high && arr[left] < arr[high]) {
                left++;
            }

            while (right > 0 && arr[right] > arr[high]) {
                right--;
            }

            if (left >= right)
                break;
            else {
                Swap.swap(arr, left, right);
            }
        }
        Swap.swap(arr, left, high);
        return left;

    }
}
