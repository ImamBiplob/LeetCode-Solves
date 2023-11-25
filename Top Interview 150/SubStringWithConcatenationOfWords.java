import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SubStringWithConcatenationOfWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        List<Integer> ansList = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.stream(words).toList());
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            String word = s.substring(i, i + wordLength);
            if (wordList.contains(word)) {
                List<String> tempList = new ArrayList<>();
                tempList.add(word);
                Map<String, Integer> tempMap = new HashMap<>();
                tempMap.put(word, 1);

                for (int j = i + wordLength; j < i + (words.length * wordLength); j++) {
                    String currentWord = s.substring(j, j + wordLength);
                    if (wordList.contains(currentWord)
                            && (tempMap.get(currentWord) == null || tempMap.get(currentWord) < map.get(currentWord))) {
                        j = j + wordLength - 1;
                        tempList.add(currentWord);
                        tempMap.put(currentWord, tempMap.getOrDefault(currentWord, 0) + 1);
                    } else {
                        tempList.removeAll(tempList);
                        break;
                    }
                }

                if (tempList.size() == words.length) {
                    ansList.add(i);
                }
            }
        }

        return ansList;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        if (words[0].length() * words.length > s.length())
            return new ArrayList<>();

        Map<String, Integer> word_frq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Map store the frequency of every word in words[]

        for (String str : words)
            word_frq.put(str, word_frq.getOrDefault(str, 0) + 1);

        int wordlen = words[0].length();

        String[] str = new String[s.length()];

        for (int i = 0; i < wordlen; i++) {
            Map<String, Integer> frq = new HashMap<>(); // count frequency of words inside the window

            int begin = i, size = 0; // size is the no. of window and begin is the starting index of window

            // s.length()-wordlen -> based on observation

            for (int j = i; j <= s.length() - wordlen; j += wordlen) {
                str[j] = s.substring(j, j + wordlen); // window
                if (word_frq.containsKey(str[j])) {
                    begin = begin == -1 ? j : begin; // begin=-1 means new window need to be started
                    frq.put(str[j], frq.getOrDefault(str[j], 0) + 1);
                    size++;

                    if (size == words.length) // substring may be possible
                    {
                        if (frq.equals(word_frq))
                            ans.add(begin);

                        // sliding the window

                        frq.put(str[begin], frq.get(str[begin]) - 1);
                        begin += wordlen; // new starting index
                        size--;
                    }
                } else // reset window
                {
                    begin = -1;
                    size = 0;
                    frq.clear();
                }
            }
        }
        return ans;
    }
}
