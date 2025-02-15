class MRUQueue {

    ArrayList<Integer> arr;

    public MRUQueue(int n) {
        arr = new ArrayList();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
    }

    public int fetch(int k) {
        int f = arr.get(k - 1);
        arr.remove(k - 1);
        arr.add(f);
        return f;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */