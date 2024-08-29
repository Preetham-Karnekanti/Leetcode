class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount[] = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            oneCount[i] = count;
            if (s.charAt(i) == '1')
                count++;
        }
        count = 0;
        int zeroCount[] = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            zeroCount[i] = count;
            if (s.charAt(i) == '0')
                count++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, oneCount[i] + zeroCount[i]);
        }
        return min;
    }
}