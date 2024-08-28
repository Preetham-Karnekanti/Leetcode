class Solution {
    public int getKth(int lo, int hi, int k) {
        Integer[] arr = new Integer[hi - lo + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = lo++;
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(arr, (a, b) -> {
            int count1 = hm.getOrDefault(a, getCount(a));
            hm.putIfAbsent(a, count1);
            int count2 = hm.getOrDefault(b, getCount(b));
            hm.putIfAbsent(b, count2);
            if (count1 == count2)
                return a - b;
            return count1 - count2;
        });
        return arr[k - 1];
    }

    public int getCount(int a) {
        int count = 0;
        while (a != 1) {
            if (a % 2 == 0)
                a = a / 2;
            else
                a = 3 * a + 1;
            count++;
        }
        return count;
    }
}