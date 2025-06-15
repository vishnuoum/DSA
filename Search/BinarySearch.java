import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = arr.length;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter item to be searched: ");
        int key = Integer.parseInt(in.readLine());
        int left = 0;
        int right = n - 1;
        while (left >= 0 && right < n && left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                System.out.println("Key found");
                System.exit(0);
            } else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println("Key not found");
    }
}
