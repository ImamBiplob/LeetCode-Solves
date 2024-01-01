import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        int count = 0;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    s[j] = 0;
                    break;
                }
            }
        }

        return count;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;

        while (count < g.length && index < s.length) {
            if (s[index] >= g[count]) {
                count++;
            }
            index++;
        }

        return count;
    }
}
