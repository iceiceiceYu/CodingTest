import java.util.Scanner;

public class TestTencent2021_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int t = input.nextInt();

        int[][] mp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mp[i][j] = input.nextInt();
            }
        }

        if (t + 2 < n + m) {
            System.out.println(0);
        } else if ((n + m - 2) % 2 != t % 2) {
            System.out.println(0);
        } else {

        }
    }
}
