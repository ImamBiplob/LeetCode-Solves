public class MinimumNumberOfStepsToMakeTwoStringsAnagrams {
    public int minSteps(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            arr[sCharArr[i] - 'a']++;
            arr[tCharArr[i] - 'a']--;
        }

        for (int num : arr) {
            if (num > 0)
                count += num;
        }

        return count;
    }

    public int minSteps2(String s, String t) {
        byte[] sByteArr = s.getBytes();
        byte[] tByteArr = t.getBytes();

        int[] arr = new int[26];
        int count = 0;

        for (int i = 0; i < sByteArr.length; i++) {
            arr[sByteArr[i] - 'a']++;
            arr[tByteArr[i] - 'a']--;
        }

        for (int num : arr) {
            if (num > 0)
                count += num;
        }

        return count;
    }
}
