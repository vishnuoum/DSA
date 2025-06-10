import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearch {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter item to be searched: ");
        int key = Integer.parseInt(in.readLine());
        for (int i : arr) {
            if (i == key) {
                System.out.println("Key found");
                System.exit(0);
            }
        }
        System.out.println("Key not found");
    }
}