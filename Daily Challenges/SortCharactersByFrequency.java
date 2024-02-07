import java.util.*;

public class SortCharactersByFrequency {
    class CharCounter {
        char ch;
        int count;

        CharCounter(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<CharCounter> list = new ArrayList<>();

        for (var key : map.keySet()) {
            CharCounter temp = new CharCounter(key, map.get(key));
            list.add(temp);
        }

        list.sort((c1, c2) -> c2.count - c1.count);

        String ans = "";
        for (CharCounter c : list) {
            char[] chars = new char[c.count];
            Arrays.fill(chars, c.ch);
            ans = ans + (String.valueOf(chars));
        }

        return ans;
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        pq.addAll(hm.entrySet());

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }

    public String frequencySort3(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        TreeMap<Integer, List<Character>> r = new TreeMap<>(Collections.reverseOrder());
        StringBuilder ss = new StringBuilder();

        for (char a : s.toCharArray())
            mp.put(a, mp.getOrDefault(a, 0) + 1);

        for (var key : mp.keySet()) {
            if (!r.containsKey(mp.get(key))) {
                r.put(mp.get(key), new ArrayList<>());
            }
            r.get(mp.get(key)).add(key);
        }

        for (var key : r.keySet()) {
            List<Character> chars = r.get(key);
            for (char c : chars) {
                for (int i = 0; i < key; i++) {
                    ss.append(c);
                }
            }
        }

        return ss.toString();
    }

    public String frequencySort4(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters based on their frequency in descending order
        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
        Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));

        // Step 3: Build the result string by repeating characters according to their
        // frequency
        StringBuilder result = new StringBuilder();
        for (char c : sortedChars) {
            result.append(String.valueOf(c).repeat(charCount.get(c)));
        }

        // Step 4: Return the final sorted string
        return result.toString();
    }
}
