import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InterviewMeiTuan2021_1 {
    public static void main(String[] args) {

    }

    private static void print(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> children = new ArrayList<>();
            Node tmp;

            while (!queue.isEmpty()) {
                tmp = queue.poll();
                if (tmp.left != null) {
                    children.add(tmp.left);
                }
                if (tmp.right != null) {
                    children.add(tmp.right);
                }
                if (queue.isEmpty()) {
                    print(tmp);
                }
            }

            queue.addAll(children);
        }
    }

    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }
}
