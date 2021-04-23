import java.util.Scanner;

public class TestAlibaba2021_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int T = input.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        int[][] graph = new int[n][3];
        for (int i = 0; i < n - 1; i++) {
            graph[i][0] = input.nextInt();
            graph[i][1] = input.nextInt();
            graph[i][2] = input.nextInt();
            if (graph[i][0] > graph[i][1]) {
                int temp = graph[i][0];
                graph[i][1] = graph[i][0];
                graph[i][0] = temp;
            }
        }

        int i = maxValue(array, graph, n, T, 1);
        System.out.println(i);
    }

    private static int maxValue(int[] array, int[][] graph, int n, int T, int start) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = array[start - 1];
            if (graph[i][0] == start) {
                if (T >= 2 * graph[i][2]) {
                    temp += maxValue(array, graph, n, T - 2 * graph[i][2], graph[i][1]);
                }
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
        return max;
    }
}
