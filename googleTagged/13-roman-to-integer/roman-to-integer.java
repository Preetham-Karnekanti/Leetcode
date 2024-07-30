class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int ans = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int first = hm.get(ch[i]);
            if (i + 1 < ch.length && first < hm.get(ch[i + 1])) {
                ans += hm.get(ch[i + 1]) - first;
                i++;
            } else
                ans += first;
        }
        return ans;
    }
}