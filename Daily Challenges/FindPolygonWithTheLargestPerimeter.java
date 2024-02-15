import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter { // Find Polygon With the Largest Perimeter
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
        }

        return -1;
    }

    public long largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        long ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < sum) {
                ans = nums[i] + sum;
            }
            sum += nums[i];
        }

        return ans;
    }
}
