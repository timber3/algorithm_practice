import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            char[] word = sc.nextLine().toCharArray();
            Arrays.sort(word);
            System.out.println(word);

            while (nextPermutation(word)) {
                System.out.println(word);
            }
        }
    }
    
    static boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        swap(arr, i, j);

        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}