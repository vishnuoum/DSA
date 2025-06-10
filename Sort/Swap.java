public class Swap {
    public static void swap(int[] arr, int i, int j) {
        assert (null != arr);
        assert (i >= 0 && i < arr.length);
        assert (j >= 0 && j < arr.length);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
