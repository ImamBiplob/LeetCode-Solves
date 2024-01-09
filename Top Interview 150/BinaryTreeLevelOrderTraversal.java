import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (root == null) {
            return resultList;
        }

        q.add(root);
        while (!q.isEmpty()) {
            int numberOfNodesInCurrentLevel = q.size();
            List<Integer> currentLevelNodesList = new ArrayList<>();

            for (int i = 0; i < numberOfNodesInCurrentLevel; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                currentLevelNodesList.add(q.remove().val);
            }

            resultList.add(currentLevelNodesList);
        }

        return resultList;
    }
}
