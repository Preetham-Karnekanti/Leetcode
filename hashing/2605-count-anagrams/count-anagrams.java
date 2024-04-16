import java.math.BigInteger;

class Solution {
    long m = (long) 1e9 + 7;
    long factorials[];

    public int countAnagrams(String s) {
        String words[] = s.split(" ");
        factorials = fact(s.length());
        long ans = 1;
        for (String word : words) {
            ans = (ans * countWays(word)) % m;
        }
        return (int) ans;
    }

    public long countWays(String w) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : w.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        long all = factorials[w.length()];
        for (int v : hm.values()) {
            long inv = BigInteger.valueOf(factorials[v]).modInverse(BigInteger.valueOf(m)).longValue();
            all = all * inv % m;
        }
        return all;
    }

    public long[] fact(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] * i) % m;
        }
        return arr;
    }
}