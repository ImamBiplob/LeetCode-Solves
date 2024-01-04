public class BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumHelper(root);

        return maxSum;
    }

    public int maxSumHelper(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = maxSumHelper(root.left);
        int rightMax = maxSumHelper(root.right);

        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);

        maxSum = Math.max(maxSum, maxAll);

        return maxOneNodeRoot;
    }
}
