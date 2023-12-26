public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumPath(root, 0);

        return sum;
    }

    public void sumPath(TreeNode curr, int num) {
        if (curr.left == null && curr.right == null) {
            num = (10 * num) + curr.val;
            sum += num;

            return;
        } else {
            num = (10 * num) + curr.val;
        }

        if (curr.left != null)
            sumPath(curr.left, num);
        if (curr.right != null)
            sumPath(curr.right, num);
    }
}
