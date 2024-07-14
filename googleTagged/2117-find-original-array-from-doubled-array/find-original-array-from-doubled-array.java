class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1)
            return new int[0];

        Arrays.sort(changed);
        int ans[] = new int[n / 2];
        int idx = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (changed[i] % 2 == 0 && hm.containsKey(changed[i] / 2)) {
                ans[idx++] = changed[i] / 2;
                hm.put(changed[i] / 2, hm.get(changed[i] / 2) - 1);
                if (hm.get(changed[i] / 2) == 0)
                    hm.remove(changed[i] / 2);
            } else {
                hm.put(changed[i], hm.getOrDefault(changed[i], 0) + 1);
            }
        }
        return idx == n / 2 ? ans : new int[0];
    }
}