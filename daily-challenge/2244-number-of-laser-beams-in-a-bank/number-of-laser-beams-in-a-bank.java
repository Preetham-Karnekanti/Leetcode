class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = count1(bank[i]);
            if (count > 0) {
                sum = sum + count * prev;
                prev = count;
            }
        }
        return sum;
    }

    public int count1(String code) {
        int count = 0;
        for (int i = 0; i < code.length(); i++)
            if (code.charAt(i) == '1')
                count++;
        return count;
    }
}