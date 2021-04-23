import java.util.Arrays;
import java.util.Scanner;

public class TestTencent2021_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(input.nextLine());
            String[] times = input.nextLine().split(" ");
            String[] penalties = input.nextLine().split(" ");
            Util[] utils = new Util[n];

            for (int j = 0; j < n; j++) {
                Util util = new Util(Integer.parseInt(times[j]), Integer.parseInt(penalties[j]));
                utils[j] = util;
            }

            judge(n, utils);
        }
    }

    private static void judge(int n, Util[] utils) {
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2) {
            Arrays.sort(utils);
            if (utils[1].time - utils[0].time <= 1) {
                System.out.println(Math.min(utils[0].penalty, utils[1].penalty));
            } else {
                System.out.println(0);
            }
        } else {
            Arrays.sort(utils);
            int[] dp = new int[n];
            int i = 0;
            while (i < n - 1) {
                if (utils[i + 1].time - utils[i].time <= 1) {
                    break;
                }
                i++;
            }
            if (i == n - 1) {
                System.out.println(0);
                return;
            }
            dp[i] = utils[i].penalty;
            dp[i + 1] = utils[i].penalty;


        }
    }

    static class Util implements Comparable<Util> {
        int time;
        int penalty;

        Util(int time, int penalty) {
            this.time = time;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Util o) {
            return this.time - o.time;
        }
    }
}
