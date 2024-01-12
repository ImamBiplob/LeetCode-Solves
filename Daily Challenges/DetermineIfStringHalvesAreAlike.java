public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int vowelsCount = 0;
        int midIndex = s.length() / 2;

        for (int i = 0; i < midIndex; i++) {
            char charA = s.charAt(i);
            char charB = s.charAt(midIndex + i);
            if (charA == 65 || charA == 69 || charA == 73 || charA == 79 || charA == 85 || charA == 97 || charA == 101
                    || charA == 105 || charA == 111 || charA == 117)
                vowelsCount++;
            if (charB == 65 || charB == 69 || charB == 73 || charB == 79 || charB == 85 || charB == 97 || charB == 101
                    || charB == 105 || charB == 111 || charB == 117)
                vowelsCount--;
        }

        return vowelsCount == 0;
    }

    public boolean halvesAreAlike2(String s) {
        return numberOfVowels(s.substring(0, s.length() / 2)) == numberOfVowels(s.substring(s.length() / 2));
    }

    public int numberOfVowels(String str) {
        int num = 0;
        for (char c : str.toCharArray()) {
            if (c == 65 || c == 69 || c == 73 || c == 79 || c == 85 || c == 97 || c == 101 || c == 105 || c == 111
                    || c == 117)
                num++;
        }

        return num;
    }
}
