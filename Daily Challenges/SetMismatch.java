import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, 0);
        }

        for (int num : nums) {
            map.put(num, map.get(num) + 1);
        }

        int duplicate = 0;
        int missing = 0;
        for (var key : map.keySet()) {
            if (map.get(key) > 1)
                duplicate = key;
            if (map.get(key) == 0)
                missing = key;
        }

        return new int[] { duplicate, missing };
    }

    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        int[] v = new int[n + 1];
        int missing = 0, duplicate = 0;

        for (int i = 0; i < n; i++) {
            v[nums[i]]++;
        }

        for (int i = 1; i < v.length; i++) {
            if (v[i] == 2) {
                duplicate = i;
            }
            if (v[i] == 0) {
                missing = i;
            }
        }

        return new int[] { duplicate, missing };
    }

    public int[] findErrorNums3(int[] nums) {
        int n = nums.length;
        int actual_sum = n * (n + 1) / 2;
        int arraySum = 0;
        int uniqueSum = 0;
        Set<Integer> s = new HashSet<>();

        for (int a : nums) {
            arraySum += a;
        }

        for (int a : nums) {
            s.add(a);
        }

        for (int a : s) {
            uniqueSum += a;
        }

        int missing = actual_sum - uniqueSum;
        int duplicate = arraySum - uniqueSum;

        return new int[] { duplicate, missing };
    }
}
