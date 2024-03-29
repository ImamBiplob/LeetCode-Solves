public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        long maxNum = Long.MIN_VALUE, count = 0;
        long left = 0, right = 0, ans = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        while (right < nums.length || left > right) {
            if (nums[(int) right] == maxNum) {
                count++;
            }

            while (count >= k) {
                if (nums[(int) left] == maxNum) {
                    count--;
                }
                left++;
                ans += nums.length - right;
            }
            right++;
        }

        return ans;
    }

    public long countSubarrays2(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0, n = nums.length;

        for (int num : nums)
            max = Math.max(max, num);

        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;

            while (count >= k) {
                res += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
        }

        return res;
    }
}
