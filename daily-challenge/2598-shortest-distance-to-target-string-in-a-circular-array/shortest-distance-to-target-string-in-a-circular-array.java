class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int min = Integer.MAX_VALUE;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(i - startIndex);
                min = Math.min(min, Math.min(distance, n - distance));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}