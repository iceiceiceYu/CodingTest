import java.util.Scanner;

public class TestTencent2021_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine());
        for (int i = 0; i < t; i++) {
            if (judgeHelper(input.nextLine(), input.nextLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean judgeHelper(String a, String b) {
        int len = a.length();
        if (len % 2 == 1) {
            return a.equals(b);
        } else {
            String a1 = a.substring(0, len / 2);
            String a2 = a.substring(len / 2);
            String b1 = b.substring(0, len / 2);
            String b2 = b.substring(len / 2);

            return (judgeHelper(a1, b1) && judgeHelper(a2, b2)) || (judgeHelper(a1, b2) && judgeHelper(a2, b1));
        }
    }
}
