class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm1.put(arr[i], hm1.getOrDefault(arr[i], 0) + 1);
            hm2.put(target[i], hm2.getOrDefault(target[i], 0) + 1);
        }
        return hm1.equals(hm2);
    }
}