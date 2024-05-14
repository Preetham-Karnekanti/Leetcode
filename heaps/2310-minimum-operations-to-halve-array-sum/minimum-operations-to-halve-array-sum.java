class Solution {
    public int halveArray(int[] nums) {
        int ans = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            pq.add((double) nums[i]);
            sum += nums[i];
        }
        double newSum = sum;
        while (newSum > (sum / 2)) {
            double val = pq.remove();
            newSum -= val/2;
            pq.add(val/2);
            ans++;
        }
        return ans;
    }
}