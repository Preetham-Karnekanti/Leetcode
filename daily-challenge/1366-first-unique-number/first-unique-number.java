class FirstUnique {

    int idx;
    ArrayList<Integer> al;
    HashMap<Integer, Integer> freq;

    public FirstUnique(int[] nums) {
        idx = 0;
        al = new ArrayList<>();
        freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            al.add(nums[i]);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
    }

    public int showFirstUnique() {
        while (idx < al.size() && freq.get(al.get(idx)) != 1) {
            idx++;
        }
        if (idx == al.size())
            return -1;
        return al.get(idx);
    }

    public void add(int value) {
        al.add(value);
        freq.put(value, freq.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */