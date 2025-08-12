class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        int i = 0;
        int j = prices.length - 1;
        int min = 0;
        while(i <= j){
            min += prices[i];
            i++;
            j-=k;
        }
        int max = 0;
        i = 0;
        j = prices.length - 1;
        while(i <= j){
            max += prices[j];
            j--;
            i+=k;
        }
        return new ArrayList<>(List.of(min, max));
    }
}
