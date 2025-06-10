import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 1, 2, 3, 4, 5, 9, 6 };
        int n = arr.length;
        System.out.println("Before Merge Sort");
        System.err.println(Arrays.toString(arr));
        mergeSort(arr, 0, n - 1);
        System.out.println("After Merge Sort");
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n = right - left + 1;
        int[] b = new int[n];
        int index = 0;

        int i1 = left;
        int i2 = mid + 1;
        while (i1 <= mid && i2 <= right) {
            if (arr[i1] < arr[i2]) {
                b[index++] = arr[i1++];
            } else {
                b[index++] = arr[i2++];
            }
        }

        while (i1 <= mid) {
            b[index++] = arr[i1++];
        }

        while (i2 <= right) {
            b[index++] = arr[i2++];
        }

        System.arraycopy(b, 0, arr, left, b.length);

    }
}
