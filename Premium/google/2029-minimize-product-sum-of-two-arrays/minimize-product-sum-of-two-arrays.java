class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(nums1);
        for(int i: nums2)
            max.add(i);
        int sum = 0;
        for(int i: nums1){
            sum += i * max.poll();
        }
        return sum;
    }
}