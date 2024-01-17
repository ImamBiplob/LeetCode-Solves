import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (var key : map.keySet()) {
            if (set.contains(map.get(key)))
                return false;

            set.add(map.get(key));
        }

        return true;
    }
}
