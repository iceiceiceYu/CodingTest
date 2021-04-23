import java.util.Scanner;

public class TestMeiTuan2021_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
    }

    class Node {
        int threshold;
        Node left;
        Node right;

        Node(int threshold, Node left, Node right) {
            this.threshold = threshold;
            this.left = left;
            this.right = right;
        }
    }
}
