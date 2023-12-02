import java.util.Arrays;

public class LCS {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxSequence = 1;
        int currentMaxSeq = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentMaxSeq++;
                    if (currentMaxSeq > maxSequence)
                        maxSequence = currentMaxSeq;
                } else {
                    currentMaxSeq = 1;
                }
            }
        }

        return maxSequence;
    }
}
