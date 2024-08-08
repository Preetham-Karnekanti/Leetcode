class TwoSum {

    HashMap<Long, Integer> hm;
    ArrayList<Long> al;

    public TwoSum() {
        hm = new HashMap<>();
        al = new ArrayList<>();
    }

    public void add(int number) {
        long num = (long) number;
        hm.put(num, hm.getOrDefault(num, 0) + 1);
        al.add(num);
    }

    public boolean find(int value) {
        for (int i = 0; i < al.size(); i++) {
            long target = (long) value - al.get(i);
            if (target == al.get(i) && hm.getOrDefault(target, 0) > 1)
                return true;
            else if (target != al.get(i) && hm.containsKey(target))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */