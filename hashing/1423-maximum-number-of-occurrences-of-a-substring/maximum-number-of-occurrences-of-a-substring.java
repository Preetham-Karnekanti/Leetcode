class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char ch[] = s.toCharArray();
        int max = 0;
        HashMap<String, Integer> ans = new HashMap<>();
        for (int size = minSize; size <= maxSize; size++) {
            max = Math.max(max, countOuccrances(size, maxLetters, ch, s, ans));
        }
        return max;
    }

    public int countOuccrances(int size, int maxLetters, char ch[], String s, HashMap<String, Integer> ans) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < size; i++) {
            hm.put(ch[i], hm.getOrDefault(ch[i], 0) + 1);
        }
        if (hm.size() <= maxLetters) {
            String str = s.substring(0, size);
            ans.put(str, ans.getOrDefault(str, 0) + 1);
            max = Math.max(max, ans.get(str));
        }
        for (int i = size; i < ch.length; i++) {
            hm.put(ch[left], hm.get(ch[left]) - 1);
            if (hm.get(ch[left]) == 0)
                hm.remove(ch[left]);
            hm.put(ch[i], hm.getOrDefault(ch[i], 0) + 1);
            left++;
            if (hm.size() <= maxLetters) {
                String str = s.substring(left, i + 1);
                ans.put(str, ans.getOrDefault(str, 0) + 1);
                max = Math.max(max, ans.get(str));
            }
        }
        return max;
    }
}