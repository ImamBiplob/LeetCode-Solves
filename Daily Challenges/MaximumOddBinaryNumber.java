import java.util.*;

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('1', 0);
        map.put('0', 0);

        for (char ch : s.toCharArray()) {
            if (ch == '1')
                map.put('1', map.get('1') + 1);
            else
                map.put('0', map.get('0') + 1);
        }

        return "1".repeat(map.get('1') - 1) + "0".repeat(map.get('0')) + "1";
    }

    public String maximumOddBinaryNumber2(String s) {
        int cnt1 = 0, cnt0 = 0;
        for (char a : s.toCharArray()) {
            if (a == '1')
                cnt1++;
            else if (a == '0')
                cnt0++;
        }

        StringBuilder ans = new StringBuilder();
        ans.append("1".repeat(cnt1 - 1));
        ans.append("0".repeat(cnt0));
        ans.append("1");

        return ans.toString();
    }

    public String maximumOddBinaryNumber3(String s) {
        int len = s.length();
        int ones = -1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++, ones--) {
            sb.append(ones > 0 ? '1' : '0');
        }

        return sb.append('1').toString();
    }
}
