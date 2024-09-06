class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums1)
            min.add(i);
        for(int i: nums2)
            max.add(i);
        int sum = 0;
        while(!min.isEmpty() && !max.isEmpty()){
            sum += min.poll()*max.poll();
        }
        return sum;
    }
}