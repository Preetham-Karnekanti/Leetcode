class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = numBottles;
        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int remBottles = numBottles % numExchange;
            count = count + newBottles;
            numBottles = newBottles + remBottles;
        }
        return count;
    }
}