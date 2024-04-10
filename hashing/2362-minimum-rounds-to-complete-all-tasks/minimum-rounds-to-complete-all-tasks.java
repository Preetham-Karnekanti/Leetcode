class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i : tasks) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        for (int value : hm.values()) {
            if(value < 2)
                return -1;
            count += value / 3;
            if (value % 3 != 0)
                count++;
        }
        return count;
    }
}