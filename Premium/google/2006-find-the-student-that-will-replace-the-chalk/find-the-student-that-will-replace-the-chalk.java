class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++)
            sum += chalk[i];
        long temp = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if (temp < chalk[i])
                return i;
            temp -= chalk[i];
        }
        return -1;
    }
}