class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            if(arr[i] % k == 0)
                pq.add(0);
            else pq.add(k - (arr[i] % k));
        }
        int m = arr.length/2;
        if(arr.length%2==1)m++;
        int ans = 0;
        for(int i = 0;i<m;i++){
            ans += pq.poll();
        }
        return ans;
    }
}