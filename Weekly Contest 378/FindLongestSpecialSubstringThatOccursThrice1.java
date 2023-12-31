import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThrice1 {
    public int maximumLength(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i != 0 && s.charAt(i) == s.charAt(i - 1)) {
                int start = i - 1;
                while (i != n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
                int end = i;
                int length = end - start + 1;
                for (int j = 0; j < length; j++) {
                    String substring = s.substring(start, start + j + 1);
                    if (j == 0) {
                        map.put(substring, map.getOrDefault(substring, 0) + length - 1);
                    } else {
                        map.put(substring, map.getOrDefault(substring, 0) + length - j);
                    }
                }
            } else {
                map.put(s.substring(i, i + 1), map.getOrDefault(s.substring(i, i + 1), 0) + 1);
            }
        }

        int maxLength = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                maxLength = Math.max(entry.getKey().length(), maxLength);
            }
        }

        return maxLength;
    }
}
