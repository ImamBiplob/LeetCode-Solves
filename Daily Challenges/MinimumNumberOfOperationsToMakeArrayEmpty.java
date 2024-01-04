import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalOps = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq == 1)
                return -1;
            else if (freq % 3 == 0)
                totalOps += freq / 3;
            else
                totalOps += (freq / 3 + 1);
        }

        return totalOps;
    }

    public int minOperations2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalOps = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq == 1)
                return -1;

            totalOps += freq / 3;

            if (freq % 3 != 0)
                totalOps++;
        }

        return totalOps;
    }
}
