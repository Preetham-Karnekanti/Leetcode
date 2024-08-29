class Solution {
    HashMap<String, Integer> memo;

    public int minStickers(String[] stickers, String target) {
        memo = new HashMap<>();
        int ans = helper(stickers, getFreq(target));
        return ans == (int) 1e9 ? -1 : ans;
    }

    public String getKey(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq.length; i++) {
            sb.append(freq[i]).append('#');
        }
        return sb.toString();
    }

    public int helper(String stickers[], int[] target) {
        String key = getKey(target);
        if (hasAll(target))
            return 0;
        if (memo.containsKey(key))
            return memo.get(key);
        int minStickers = (int) 1e9;

        for (String sticker : stickers) {
            int[] newTarget = target.clone();
            boolean isPickable = false;
            for (char ch : sticker.toCharArray()) {
                if (newTarget[ch - 'a'] > 0) {
                    newTarget[ch - 'a']--;
                    isPickable = true;
                }
            }

            if (isPickable) {
                minStickers = Math.min(minStickers, 1 + helper(stickers, newTarget));
            }
        }

        // Memoize the result
        memo.put(key, minStickers);
        return minStickers;
    }

    public boolean hasAll(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0)
                return false;
        }
        return true;
    }

    public int[] getFreq(String word) {
        int freq[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }
}