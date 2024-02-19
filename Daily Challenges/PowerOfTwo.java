public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans > n)
                break;
            if (ans == n)
                return true;
        }

        return false;
    }
}
