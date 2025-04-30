class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count += String.valueOf(i).length() % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}