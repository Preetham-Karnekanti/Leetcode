class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            double first = a.num / a.denom;
            double second = b.num / b.denom;
            if (first == second)
                return 0;
            if (first > second)
                return -1;
            return 1;
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new Pair(arr[i], arr[j]));
                if (pq.size() > k)
                    pq.poll();
            }
        }
        int ans[] = new int[2];
        ans[0] = (int) pq.peek().num;
        ans[1] = (int) pq.peek().denom;
        return ans;
    }
}

class Pair {
    double num;
    double denom;

    Pair(double num, double denom) {
        this.num = num;
        this.denom = denom;
    }
}