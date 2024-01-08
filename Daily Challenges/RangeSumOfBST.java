public class RangeSumOfBST {
    int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSum(root, low, high);

        return rangeSum;
    }

    private void rangeSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low <= root.val && root.val <= high) {
            rangeSum += root.val;
            rangeSum(root.left, low, high);
            rangeSum(root.right, low, high);
        } else if (root.val < low) {
            rangeSum(root.right, low, high);
        } else {
            rangeSum(root.left, low, high);
        }
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high);
        }
    }
}
