public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int pre = 0, cur = 0;

        for (int i = 0; i < n; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
