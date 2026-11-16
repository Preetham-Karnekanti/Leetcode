class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            StringBuilder temp = new StringBuilder();
            int size = sb.length();
            int groups = size / k;
            groups += size % k == 0 ? 0 : 1;
            int idx = 0;
            for (int i = 0; i < groups; i++) {
                String sub = sb.substring(idx, Math.min(size, idx + k));
                temp.append(getSum(sub));
                idx = idx + k;
            }
            sb = temp;
        }
        return sb.toString();
    }

    public String getSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        return String.valueOf(sum);
    }
}