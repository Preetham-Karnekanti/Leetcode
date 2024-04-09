class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        int element = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] >= element) {
                if (i <= k)
                    count += element;
                else
                    count += element - 1;
            } else {
                count += tickets[i];
            }
        }
        return count;
    }
}