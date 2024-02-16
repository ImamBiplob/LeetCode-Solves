import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> elements = new ArrayList<>(map.entrySet());

        elements.sort((a, b) -> a.getValue() - b.getValue());

        for (var entry : elements) {
            if (entry.getValue() <= k) {
                k -= entry.getValue();
                map.remove(entry.getKey());
            } else {
                break;
            }
        }

        return map.size();
    }

    public int findLeastNumOfUniqueInts2(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> a - b);

        int ans = list.size();
        for (int n : list) {
            if (n <= k) {
                k -= n;
                ans--;
            } else
                break;
        }

        return ans;
    }
}
