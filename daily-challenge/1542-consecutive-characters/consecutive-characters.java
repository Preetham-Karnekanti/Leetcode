class Solution {
    public int maxPower(String s) {
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            while (hm.size() > 1) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                if (hm.get(s.charAt(left)) == 0)
                    hm.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}