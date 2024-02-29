import java.util.ArrayDeque;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        boolean oddFlag = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = oddFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (oddFlag) {
                    if (node.val % 2 == 0 || node.val <= prev) {
                        return false;
                    }
                } else if (node.val % 2 != 0 || node.val >= prev) {
                    return false;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                prev = node.val;
            }
            oddFlag = !oddFlag;
        }

        return true;
    }
}
