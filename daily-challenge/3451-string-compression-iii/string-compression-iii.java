class Solution {
    public String compressedString(String word) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        while (i < n) {
            int count = 0;
            char ch = word.charAt(i);
            while (i < n && ch == word.charAt(i) && count < 9) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(ch);
        }

        return sb.toString();
    }
}