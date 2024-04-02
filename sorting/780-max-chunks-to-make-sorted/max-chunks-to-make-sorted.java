class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
            if (hasAll(hs, i))
                count++;
        }
        return count;
    }

    public boolean hasAll(HashSet<Integer> set, int k) {
        for (int i = 0; i <= k; i++) {
            if (!set.contains(i))
                return false;
        }
        return true;
    }
}