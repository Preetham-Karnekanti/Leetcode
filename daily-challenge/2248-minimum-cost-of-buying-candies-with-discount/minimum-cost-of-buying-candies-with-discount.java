class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int i = cost.length - 1;
        int answer = 0;
        while (i >= 0) {
            answer += cost[i];
            if (i - 1 >= 0)
                answer += cost[i - 1];
            i -= 3;
        }
        return answer;
    }
}