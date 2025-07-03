class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while (sb.length() <= k) {
            int len = sb.length();
            for (int i = 0; i < len; i++) {
                char nextChar = sb.charAt(i) == 'z' ? 'a' : (char) (sb.charAt(i) + 1);
                sb.append(nextChar);
                if (sb.length() == k)
                    return nextChar;
            }
        }
        return sb.charAt(k - 1);
    }
}