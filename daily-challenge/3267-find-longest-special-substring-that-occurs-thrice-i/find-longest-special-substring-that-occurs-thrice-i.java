class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j))
                    break;
                temp += s.charAt(j);
                hm.put(temp, hm.getOrDefault(temp, 0) + 1);
            }
        }
        int maxLen = -1;
        for (String str : hm.keySet()) {
            if (hm.get(str) >= 3 && str.length() > maxLen)
                maxLen = str.length();
        }
        return maxLen;
    }
}