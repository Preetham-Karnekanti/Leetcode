class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int x = rotate(i);
            if (x != -1 && x != i){
                count++;
            }
        }
        return count;
    }

    public int rotate(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(8, 8);
        hm.put(2, 5);
        hm.put(5, 2);
        hm.put(6, 9);
        hm.put(9, 6);
        int num = 0;
        int mul = 1;
        while (n != 0) {
            int rem = n % 10;
            if (hm.containsKey(rem) == false)
                return -1;
            rem = hm.get(rem);
            num = rem * mul + num;
            mul *= 10;
            n = n / 10;
        }
        return num;
    }
}