class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = s.length();
        while (i < n) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}