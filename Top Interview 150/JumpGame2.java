public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int jumpCount = 0;
        int i = 0;

        while (true) {
            if (i >= nums.length - 1) {
                break;
            }

            int maxJumpIndex = i;
            int max = nums[i];
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    return ++jumpCount;
                }

                if (nums[i + j] + j > max) {
                    max = nums[i + j] + j;
                    maxJumpIndex = i + j;
                }
            }

            i = maxJumpIndex;
            jumpCount++;
        }

        return jumpCount;
    }
}
