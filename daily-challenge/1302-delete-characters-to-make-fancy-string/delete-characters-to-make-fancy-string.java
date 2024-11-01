class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("AA");
        for (int i = 0; i < s.length(); i++) {
            char last = sb.charAt(sb.length() - 1);
            char lastButOne = sb.charAt(sb.length() - 2);
            if (s.charAt(i) == last && s.charAt(i) == lastButOne)
                continue;
            sb.append(s.charAt(i));
        }
        return sb.toString().substring(2);
    }
}