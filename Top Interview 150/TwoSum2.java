public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left != right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { left + 1, right + 1 };
    }

    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] { left + 1, right + 1 };
    }
}
