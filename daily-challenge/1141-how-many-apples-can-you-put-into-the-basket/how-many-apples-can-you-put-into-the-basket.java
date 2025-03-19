class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int count = 0;
        for (int i : weight) {
            if (sum + i > 5000)
                return count;
            sum += i;
            count++;
        }
        return count;
    }
}