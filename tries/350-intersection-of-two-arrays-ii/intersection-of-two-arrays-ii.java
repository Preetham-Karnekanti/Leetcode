class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : nums2) {
            if (hm.containsKey(i)) {
                al.add(i);
                hm.put(i, hm.get(i) - 1);
                if (hm.get(i) == 0)
                    hm.remove(i);
            }
        }
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++)
            arr[i] = al.get(i);
        return arr;
    }
}