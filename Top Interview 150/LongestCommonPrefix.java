import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firsString = strs[0];
        String lastString = strs[strs.length - 1];
        int index = 0;

        while (index < firsString.length() && index < lastString.length()) {
            if (firsString.charAt(index) == lastString.charAt(index)) {
                index++;
            } else {
                break;
            }
        }

        return firsString.substring(0, index);
    }
}
