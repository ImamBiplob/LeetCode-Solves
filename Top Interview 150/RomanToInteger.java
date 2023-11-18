import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int intResult = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I') {
                if (i < chars.length - 1 && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    intResult -= 1;
                } else {
                    intResult += 1;
                }
            }

            else if (chars[i] == 'X') {
                if (i < chars.length - 1 && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    intResult -= 10;
                } else {
                    intResult += 10;
                }
            }

            else if (chars[i] == 'C') {
                if (i < chars.length - 1 && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    intResult -= 100;
                } else {
                    intResult += 100;
                }
            }

            else {
                intResult += map.get(chars[i]);
            }
        }

        return intResult;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int intResult = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
                intResult -= map.get(chars[i]);
            } else {
                intResult += map.get(chars[i]);
            }
        }

        return intResult;
    }

    public int romanToInt3(String s) {

        int intResult = 0, intValue = 0, prevIntValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> intValue = 1000;
                case 'D' -> intValue = 500;
                case 'C' -> intValue = 100;
                case 'L' -> intValue = 50;
                case 'X' -> intValue = 10;
                case 'V' -> intValue = 5;
                case 'I' -> intValue = 1;
            }

            if (intValue < prevIntValue) {
                intResult -= intValue;
            } else {
                intResult += intValue;
            }

            prevIntValue = intValue;
        }

        return intResult;
    }
}
