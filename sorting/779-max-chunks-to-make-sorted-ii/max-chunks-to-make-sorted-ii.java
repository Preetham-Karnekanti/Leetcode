class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(arr1);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hasAll(i, arr1, arr))
                count++;
        }
        return count;
    }

    public boolean hasAll(int idx, int[] sorted, int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i <= idx; i++)
            hm.put(sorted[i], hm.getOrDefault(sorted[i], 0) + 1);
        for (int i = 0; i <= idx; i++) {
            if (!hm.containsKey(arr[i]) || hm.get(arr[i]) == 0)
                return false;
            hm.put(arr[i], hm.get(arr[i]) - 1);
        }
        return true;

    }
}