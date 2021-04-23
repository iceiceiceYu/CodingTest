import java.util.Scanner;

public class TestAlibaba2021_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int len = 2 * k;
        int[] reverse = new int[len];
        for (int i = 0; i < len; i++) {
            reverse[i] = input.nextInt();
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < len; i += 2) {
            reverse(array, reverse[i], reverse[i + 1]);
        }

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void reverse(int[] array, int left, int right) {
        while (left < right) {
            int temp = array[left - 1];
            array[left - 1] = array[right - 1];
            array[right - 1] = temp;
            left++;
            right--;
        }
    }
}
