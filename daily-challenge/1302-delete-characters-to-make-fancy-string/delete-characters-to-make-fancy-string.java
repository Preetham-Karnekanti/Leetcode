class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                count++;
                i++;
            }
            if (count >= 3)
                count = 2;
            if (count < 3) {
                for (int j = 0; j < count; j++)
                    sb.append(ch);
            }
        }
        return sb.toString();
    }
}