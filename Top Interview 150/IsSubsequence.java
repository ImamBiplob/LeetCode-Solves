public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (t.length() < s.length())
            return false;

        int j = 0;
        char[] sArr = s.toCharArray();
        for (char ch : t.toCharArray()) {
            if (ch == sArr[j]) {
                j++;
                if (j == sArr.length)
                    return true;
            }
        }

        return false;
    }
}
