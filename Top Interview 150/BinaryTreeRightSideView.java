import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<Integer>();

        rightView(root, resultList, 0);

        return resultList;
    }

    public void rightView(TreeNode curr, List<Integer> resultList, int currLevel) {
        if (curr == null) {
            return;
        }
        if (currLevel == resultList.size()) {
            resultList.add(curr.val);
        }

        rightView(curr.right, resultList, currLevel + 1);
        rightView(curr.left, resultList, currLevel + 1);
    }
}
