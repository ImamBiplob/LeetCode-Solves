import java.util.*;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int length = nums.length;
        if (length % 3 != 0)
            return new int[0][0];

        Arrays.sort(nums);

        int[][] ans = new int[length / 3][3];
        int rowIndex = 0;
        for (int i = 0; i < length; i += 3) {
            if (i + 2 < length && nums[i + 2] - nums[i] <= k) {
                int[] temp = { nums[i], nums[i + 1], nums[i + 2] };
                ans[rowIndex++] = temp;
            } else {
                return new int[0][0];
            }
        }

        return ans;
    }

    public int[][] divideArray2(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> ans = new ArrayList<>();

        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k)
                return new int[][] {};

            ans.add(new int[] { nums[i - 2], nums[i - 1], nums[i] });
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
