import java.util.*;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[] { 0, 0 };
        help(root, 1, result);
        return result[1];
    }

    private void help(TreeNode node, int currD, int[] result) {
        if (node == null) {
            return;
        }

        if (currD > result[0]) {
            result[0] = currD;
            result[1] = node.val;
        }

        help(node.left, currD + 1, result);
        help(node.right, currD + 1, result);
    }

    public int findBottomLeftValue2(TreeNode root) {
        int last = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    last = curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        return last;
    }
}
