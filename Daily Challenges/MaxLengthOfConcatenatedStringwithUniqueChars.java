import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenatedStringwithUniqueChars {
    public int maxLength(List<String> arr) {
        int[] maxLength = { 0 };
        backTrack(arr, "", 0, maxLength);

        return maxLength[0];
    }

    private void backTrack(List<String> arr, String current, int start, int[] maxLength) {
        if (maxLength[0] < current.length())
            maxLength[0] = current.length();

        for (int i = start; i < arr.size(); i++) {
            if (!isValid(current, arr.get(i)))
                continue;

            backTrack(arr, current + arr.get(i), i + 1, maxLength);
        }
    }

    private boolean isValid(String currentString, String newString) {
        Set<Character> charSet = new HashSet<>();

        for (char ch : newString.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }

            charSet.add(ch);

            if (currentString.contains(String.valueOf(ch))) {
                return false;
            }
        }

        return true;
    }

    public int maxLength2(List<String> arr) {
        int[] maxLength = { 0 };
        backTrack(arr, 0, 0, maxLength);

        return maxLength[0];
    }

    private void backTrack(List<String> arr, int index, int charSet, int[] maxLength) {
        if (index == arr.size()) {
            int count = 0;
            for (int i = 0; i < 26; ++i) {
                if ((charSet & (1 << i)) != 0) {
                    count++;
                }
            }
            maxLength[0] = Math.max(maxLength[0], count);
            return;
        }

        int newCharSet = charSet;
        boolean isValidString = true;

        for (char ch : arr.get(index).toCharArray()) {
            int bit = 1 << (ch - 'a');
            if ((newCharSet & bit) == 0) {
                newCharSet |= bit;
            } else {
                isValidString = false;
                break;
            }
        }

        if (isValidString) {
            backTrack(arr, index + 1, newCharSet, maxLength);
        }

        backTrack(arr, index + 1, charSet, maxLength);
    }
}
