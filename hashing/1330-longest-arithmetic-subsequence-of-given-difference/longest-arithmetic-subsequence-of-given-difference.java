class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (hm.containsKey(cur - difference)) {
                hm.put(cur, hm.get(cur - difference) + 1);
            } else
                hm.put(cur, 1);
            len = Math.max(len, hm.get(cur));
        }
        return len;
    }
}