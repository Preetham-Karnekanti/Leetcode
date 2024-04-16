class MapSum {

    HashMap<String, Integer> hm;

    public MapSum() {
        hm = new HashMap<>();
    }

    public void insert(String key, int val) {
        hm.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        for (String s : hm.keySet()) {
            if (s.startsWith(prefix))
                count += hm.get(s);
        }
        return count;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */