class Solution {
    int count;
    HashMap<Integer, Integer> hm = new HashMap<>();

    public int confusingNumberII(int n) {
        count = 0;
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(6, 9);
        hm.put(8, 8);
        hm.put(9, 6);
        int digits[] = new int[] { 0, 1, 6, 8, 9 };
        dfs(digits, 0, 0, n);
        return count;
    }

    public void dfs(int[] digits, int idx, long num, int max) {
        if (num > max) {
            return;
        }
        if (isConfusing(num)) {
            count++;
        }
        for (int d : digits) {
            if (idx == 0 && d == 0)
                continue;
            dfs(digits, idx + 1, num * 10 + d, max);
        }
    }

    public boolean isConfusing(long num) {
        long temp = num;
        long val = 0;
        while (temp != 0) {
            val = val * 10 + hm.get((int) temp % 10);
            temp /= 10;
        }
        return num != val;
    }
}