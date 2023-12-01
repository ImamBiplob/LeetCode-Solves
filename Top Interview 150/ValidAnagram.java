import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charcharCount = new HashMap<>();

        for (char ch : s.toCharArray()) {
            charcharCount.put(ch, charcharCount.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (charcharCount.get(ch) == null) {
                return false;
            }

            if (charcharCount.get(ch) == 1) {
                charcharCount.remove(ch);
            } else {
                charcharCount.put(ch, charcharCount.getOrDefault(ch, 0) - 1);
            }

        }

        return charcharCount.isEmpty() ? true : false;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] charCount = new int[26];

        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (charCount[ch - 'a'] == 0)
                return false;
            charCount[ch - 'a']--;
        }

        return true;
    }

    public boolean isAnagram3(String s, String t) {
        int[] count = new int[26];

        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }

        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
