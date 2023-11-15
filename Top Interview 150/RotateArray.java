public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] arrHead = new int[k];
        int n = nums.length - k;

        for (int i = 0; i < k; i++) {
            arrHead[i] = nums[n++];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = arrHead[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length - k;

        reverse(nums, 0, n - 1);
        reverse(nums, n, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
