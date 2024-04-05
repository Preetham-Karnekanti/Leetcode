class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String str : dictionary) {
            if (isSubsequence(s, str)) {
                if (str.length() == ans.length()) {
                    ans = smallest(ans,str);
                } else if (str.length() > ans.length()) {
                    ans = str;
                }
            }
        }
        return ans;
    }

    public boolean isSubsequence(String s, String str) {
        int i = 0;
        int j = 0;
        if (str.length() > s.length())
            return false;
        while (j < str.length() && i < s.length()) {
            if (str.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == str.length();
    }

    public String smallest(String s, String t){
        if(s.compareTo(t) > 0)
            return t;
        return s;
    }
}