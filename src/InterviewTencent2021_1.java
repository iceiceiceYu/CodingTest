import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterviewTencent2021_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        TreeNode root = buildTree(n);
        System.out.println(root.toString());
    }

    private static TreeNode buildTree(int n) {
        List<TreeNode> originalNodes = new ArrayList<>();
        List<TreeNode> addedNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            originalNodes.add(new TreeNode(i + 1));
        }

        TreeNode root = originalNodes.get((int) (Math.random() * originalNodes.size()));
        originalNodes.remove(root);
        addedNodes.add(root);

        while (originalNodes.size() > 0) {
            TreeNode originalNode = originalNodes.get((int) (Math.random() * originalNodes.size()));
            TreeNode addedNode = addedNodes.get((int) (Math.random() * addedNodes.size()));

            if (addedNode.left == null && addedNode.right == null) {
                if (Math.random() <= 0.5) {
                    addedNode.left = originalNode;
                } else {
                    addedNode.right = originalNode;
                }
            } else if (addedNode.left == null) {
                addedNode.left = originalNode;
                addedNodes.remove(addedNode);
            } else if (addedNode.right == null) {
                addedNode.right = originalNode;
                addedNodes.remove(addedNode);
            }
            originalNodes.remove(originalNode);
            addedNodes.add(originalNode);
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
