import java.util.*;

public class RabinKarp {
    static final int BASE = 256;
    static final long MOD = 1_000_000_007L;
    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        if (m > n || m == 0) return result;
        long patternHash = 0;
        long windowHash = 0;
        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * BASE) % MOD;
        }
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
            windowHash = (windowHash * BASE + text.charAt(i)) % MOD;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }
            if (i < n - m) {
                windowHash = (windowHash - text.charAt(i) * power) % MOD;
                windowHash = (windowHash * BASE + text.charAt(i + m)) % MOD;
                if (windowHash < 0)
                    windowHash += MOD;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String text = "abcabcabcadeba";
        String pattern = "cab";
        List<Integer> positions = search(text, pattern);
        System.out.println("Pattern found at: " + positions);
    }
}