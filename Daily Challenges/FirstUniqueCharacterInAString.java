import java.util.*;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1)
                return idx;
            idx++;
        }

        return -1;
    }

    public int firstUniqChar3(String s) {
        int[] map = new int[26];

        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (map[ch - 'a'] == 1)
                return idx;
            idx++;
        }

        return -1;
    }
}
