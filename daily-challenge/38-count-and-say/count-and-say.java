class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int k = 1; k < n; k++) {
            String temp = "";
            for (int i = 0; i < ans.length();) {
                char ch = ans.charAt(i);
                int count = 0;
                while (i < ans.length() && ch == ans.charAt(i)) {
                    count++;
                    i++;
                }
                temp += "" + count + ch;
            }
            ans = temp;
        }
        return ans;
    }
}