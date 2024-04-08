class Solution {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] map = new int[10];
        for (int i = 0; i < digits.length; i++) {
            map[digits[i]]++;
        }
        for (int i = 100; i <= 999; i += 2) {
            int freq1[] = getFreq(i);
            if (check(freq1, map))
                al.add(i);
        }
        int ans[] = new int[al.size()];
        int i = 0;
        for (int k : al)
            ans[i++] = k;
        return ans;
    }

    public int[] getFreq(int num) {
        int freq[] = new int[10];
        while (num > 0) {
            int rem = num % 10;
            freq[rem]++;
            num /= 10;
        }
        return freq;
    }

    public boolean check(int[] curr, int[] map) {
        for (int i = 0; i < 10; i++) {
            if (curr[i] > map[i])
                return false;
        }
        return true;
    }
}