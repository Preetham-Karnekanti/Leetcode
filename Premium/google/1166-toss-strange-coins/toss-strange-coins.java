class Solution {
    Double dp[][];

    public double probabilityOfHeads(double[] prob, int target) {
        dp = new Double[prob.length][target + 1];
        return helper(prob, target, 0);
    }

    public double helper(double prob[], int target, int idx) {
        if (target < 0)
            return 0;
        if (idx == prob.length)
            return target == 0 ? 1 : 0;
        if (dp[idx][target] != null)
            return dp[idx][target];
        double heads = prob[idx] * helper(prob, target - 1, idx + 1);
        double tails = (1 - prob[idx]) * helper(prob, target, idx + 1);
        return dp[idx][target] = heads + tails;
    }
}