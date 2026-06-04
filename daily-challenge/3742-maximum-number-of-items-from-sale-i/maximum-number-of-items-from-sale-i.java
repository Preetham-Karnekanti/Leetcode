import java.util.Arrays;

class Solution {
    private int[][] memo;
    private int minPrice;

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        
        // Initialize memoization table with -1
        memo = new int[n + 1][budget + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int[] prices = new int[n];
        int[] rewards = new int[n];
        minPrice = Integer.MAX_VALUE;

        // 1. Preprocess items to extract prices and calculate their rewards
        for (int i = 0; i < n; i++) {
            prices[i] = items[i][1];
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate reward: count how many items[j] are divisible by items[i]
            int currentReward = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % items[i][0] == 0) {
                    currentReward++;
                }
            }
            rewards[i] = currentReward;
        }

        // 2. Start the recursive knapsack function
        return solveKnapsack(prices, rewards, 0, budget);
    }

    private int solveKnapsack(int[] prices, int[] rewards, int currentIndex, int remainingBudget) {
        // Base case: No budget left
        if (remainingBudget == 0) {
            return 0;
        }
        
        // Base case: Overspent budget (invalid state)
        if (remainingBudget < 0) {
            return Integer.MIN_VALUE; 
        }
        
        // Base case: Looked through all items
        // Greedy approach: Use leftover budget on the cheapest possible item
        if (currentIndex >= prices.length) {
            return remainingBudget / minPrice;
        }

        // Return cached result if we've already computed this state
        if (memo[currentIndex][remainingBudget] != -1) {
            return memo[currentIndex][remainingBudget];
        }

        int maxReward = 0;

        // Option A: Take the current item (only if budget allows)
        if (prices[currentIndex] <= remainingBudget) {
            int take = rewards[currentIndex] + solveKnapsack(prices, rewards, currentIndex + 1, remainingBudget - prices[currentIndex]);
            int skip = solveKnapsack(prices, rewards, currentIndex + 1, remainingBudget);
            
            maxReward = Math.max(take, skip);
        } 
        // Option B: Cannot afford current item, must skip
        else {
            maxReward = solveKnapsack(prices, rewards, currentIndex + 1, remainingBudget);
        }

        // Cache and return the result
        return memo[currentIndex][remainingBudget] = maxReward;
    }
}