class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = s.length();
        char ch[] = s.toCharArray();
        while (i < n && j < spaces.length) {
            if (i == spaces[j]) {
                sb.append(" ");
                j++;
            } else {
                sb.append(ch[i++]);
            }
        }
        while (i < n) {
            sb.append(ch[i++]);
        }
        return sb.toString();
    }
}