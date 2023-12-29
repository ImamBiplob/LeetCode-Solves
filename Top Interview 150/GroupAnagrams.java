import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsUsingAbstractList(String[] strs) {
        List<List<String>> res = new AbstractList<List<String>>() {
            List<List<String>> result = null;

            public List<String> get(int index) {
                if (result == null) {
                    init();
                }

                return result.get(index);
            }

            public int size() {
                if (result == null) {
                    init();
                }

                return result.size();
            }

            private void init() {
                Map<String, List<String>> anaMap = new HashMap<>();

                for (String str : strs) {
                    char[] arr = new char[26];
                    char[] strArr = str.toCharArray();
                    for (int i = 0; i < strArr.length; i++) {
                        arr[strArr[i] - 'a']++;
                    }

                    String strKey = String.valueOf(arr);
                    anaMap.computeIfAbsent(strKey, k -> new ArrayList<>());
                    anaMap.get(strKey).add(str);
                }

                result = new ArrayList<>(anaMap.values().size());

                for (Map.Entry<String, List<String>> anaToList : anaMap.entrySet()) {
                    result.add(anaToList.getValue());
                }
            }
        };

        return res;
    }
}
