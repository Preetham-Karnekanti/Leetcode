class Solution {
    public int brokenCalc(int startValue, int target) {
        if(target <= startValue)
            return startValue - target;
        int ans = 0;
        while (target > startValue) {
            ans++;
            if (target % 2 == 1)
                target++;
            else
                target /= 2;
        }

        return ans + startValue - target;
    }
}