public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int begin = 0, end = 0, counter = t.length(), d = Integer.MAX_VALUE, head = 0;

        for (char c : t.toCharArray())
            map[c]++;

        char[] ch = s.toCharArray();
        while (end < s.length()) {
            if (map[ch[end++]]-- > 0)
                counter--;

            while (counter == 0) {
                if ((end - begin) < d)
                    d = end - (head = begin);
                if (map[ch[begin++]]++ == 0)
                    counter++;
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
