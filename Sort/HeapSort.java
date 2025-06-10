import java.util.Arrays;;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        System.out.println("Before Merge Sort");
        System.err.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println("After Merge Sort");
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        heapify(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            Swap.swap(arr, i, 0);
            int r = 0;
            int c;
            do {
                c = 2 * r + 1;
                if (c < (i - 1) && arr[c] < arr[c + 1])
                    c++;
                if (c < i && arr[r] < arr[c]) {
                    Swap.swap(arr, r, c);
                }
                r = c;
            } while (c < i);
        }
    }

    private static void heapify(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int c = i;
            int r = (c - 1) / 2;
            while (c > 0 && arr[c] > arr[r]) {
                Swap.swap(arr, c, r);
                c = r;
                r = (c - 1) / 2;
            }
        }
    }
}
