import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class LCS {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxSequence = 1;
        int currentSeq = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentSeq++;
                    if (currentSeq > maxSequence)
                        maxSequence = currentSeq;
                } else {
                    currentSeq = 1;
                }
            }
        }

        return maxSequence;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestConsecutiveSequence = 1;
        int currentConsecutiveSequence = 1;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                currentConsecutiveSequence = 1;

                while (set.contains(currentNum + 1)) {
                    currentConsecutiveSequence++;
                    currentNum += 1;
                }
            }

            if (currentConsecutiveSequence > longestConsecutiveSequence)
                longestConsecutiveSequence = currentConsecutiveSequence;
        }

        return longestConsecutiveSequence;
    }

    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        int longestConsecutiveSequence = 1;
        int currentConsecutiveSequence = 1;

        for (int num : nums) {
            if (map.get(num - 1) == null) {
                int currentNum = num;
                currentConsecutiveSequence = 1;

                while (map.get(currentNum + 1) != null) {
                    currentConsecutiveSequence++;
                    currentNum += 1;
                }
            }

            if (currentConsecutiveSequence > longestConsecutiveSequence)
                longestConsecutiveSequence = currentConsecutiveSequence;
        }

        return longestConsecutiveSequence;
    }

    public int longestConsecutive4(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int i : nums)
            set.add(i);

        int ans = 0;

        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left))
                left--;
            while (set.remove(right))
                right++;
            ans = Math.max(ans, right - left - 1);
            if (set.isEmpty())
                return ans;
        }

        return ans;
    }

    public int longestConsecutive5(int[] nums) {
        Map<Integer, Integer> ranges = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            if (ranges.containsKey(num))
                continue;

            int left = ranges.getOrDefault(num - 1, 0);
            int right = ranges.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);

            if (left > 0)
                ranges.put(num - left, sum);
            if (right > 0)
                ranges.put(num + right, sum);
            ranges.put(num, sum);
        }

        return max;
    }
}
