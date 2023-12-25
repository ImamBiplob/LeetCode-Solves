import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        int index = 0;

        while (index < firstString.length() && index < lastString.length()) {
            if (firstString.charAt(index) == lastString.charAt(index)) {
                index++;
            } else {
                break;
            }
        }

        return firstString.substring(0, index);
    }

    public String longestCommonPrefixBetterSolution(String[] strs) {
        String prefix = strs[0];

        for (String s : strs)
            while (!s.startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);

        return prefix;
    }
}
