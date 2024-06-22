public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] cnt = new int[nums.length + 1];
        cnt[0] = 1;

        int ans = 0, c = 0;
        for (int num : nums) {
            c += num & 1;

            if (c - k >= 0)
                ans += cnt[c - k];

            cnt[c]++;
        }

        return ans;
    }
}