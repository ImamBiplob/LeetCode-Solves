public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            totalSum -= nums[i];
        }

        return totalSum;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}
