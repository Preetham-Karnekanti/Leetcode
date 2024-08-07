class Solution {
    public int longestRepeatingSubstring(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                temp += s.charAt(j);
                hm.put(temp, hm.getOrDefault(temp, 0) + 1);
                if (maxLen < temp.length() && hm.get(temp) > 1) {
                    maxLen = temp.length();
                }
            }
        }
        return maxLen;
    }
}