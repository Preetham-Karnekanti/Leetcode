class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> al = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            al.add(nums[i]);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer a : al) {
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        }
        al.sort((o1, o2) -> hm.get(o1) == hm.get(o2) ? o2 - o1 : hm.get(o1) - hm.get(o2));
        int i = 0;
        for (Integer a : al) {
            nums[i] = a;
            i++;
        }
        return nums;
    }
}