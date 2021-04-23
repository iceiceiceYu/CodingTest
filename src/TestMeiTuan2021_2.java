import java.util.Scanner;

public class TestMeiTuan2021_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        long sumA = 0, sumB = 0;

        for (int i = 0; i < n; i++) {
            int count = input.nextInt();
            int power = input.nextInt();

            if (power >= k) {
                sumA += (long) count * power;
            }
        }

        for (int i = 0; i < m; i++) {
            int count = input.nextInt();
            int power = input.nextInt();

            if (power >= k) {
                sumB += (long) count * power;
            }
        }

        System.out.println(sumA + " " + sumB);
        if (sumA > sumB) {
            System.out.println("A");
        } else if (sumA < sumB) {
            System.out.println("B");
        }
    }
}
