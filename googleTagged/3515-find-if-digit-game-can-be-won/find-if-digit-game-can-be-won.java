class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleSum = 0;
        int doubleSum = 0;
        for (int i : nums) {
            if (i <= 9)
                singleSum += i;
            else
                doubleSum += i;
        }
        if (singleSum == doubleSum)
            return false;
        return true;
    }
}