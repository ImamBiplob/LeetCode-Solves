import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String result = "";

        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(500, "D");
        map.put(100, "C");
        map.put(50, "L");
        map.put(10, "X");
        map.put(5, "V");
        map.put(1, "I");

        int[] valArray = { 1000, 500, 100, 50, 10, 5, 1 };

        for (int i : valArray) {
            int div = num / i;
            num = num % i;
            for (int j = 0; j < div; j++) {
                result += map.get(i);
            }

            if ((i == 1000 && num >= 900) || (i == 500 && num >= 400)) {
                result += "C";
                result += map.get(i);
                num -= (i - 100);
                continue;
            }

            if ((i == 100 && num >= 90) || (i == 50 && num >= 40)) {
                result += "X";
                result += map.get(i);
                num -= (i - 10);
                continue;
            }

            if ((i == 10 && num >= 9) || (i == 5 && num >= 4)) {
                result += "I";
                result += map.get(i);
                num -= (i - 1);
                continue;
            }
        }

        return result;
    }

    public static String intToRoman2(int num) {
        String M[] = { "", "M", "MM", "MMM" };
        String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public String intToRoman3(int num) {

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanNumerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {

                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public String intToRoman4(int N) {
        StringBuilder res = new StringBuilder();

        while (N > 999) {
            res.append('M');
            N -= 1000;
        }

        if (N > 899) {
            res.append("CM");
            N -= 900;
        } else if (N > 499) {
            res.append('D');
            N -= 500;
        } else if (N > 399) {
            res.append("CD");
            N -= 400;
        }

        while (N > 99) {
            res.append('C');
            N -= 100;
        }

        if (N > 89) {
            res.append("XC");
            N -= 90;
        } else if (N > 49) {
            res.append('L');
            N -= 50;
        } else if (N > 39) {
            res.append("XL");
            N -= 40;
        }

        while (N > 9) {
            res.append('X');
            N -= 10;
        }

        if (N > 8) {
            res.append("IX");
            N -= 9;
        } else if (N > 4) {
            res.append('V');
            N -= 5;
        } else if (N > 3) {
            res.append("IV");
            N -= 4;
        }

        while (N > 0) {
            res.append('I');
            N -= 1;
        }

        return res.toString();
    }
}
