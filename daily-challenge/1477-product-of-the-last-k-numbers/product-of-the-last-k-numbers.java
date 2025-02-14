class ProductOfNumbers {
    ArrayList<Integer> al;

    public ProductOfNumbers() {
        al = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            al.clear();
        } else {
            int size = al.size();
            if (size == 0)
                al.add(num);
            else
                al.add(num * al.get(size - 1));
        }
    }

    public int getProduct(int k) {
        int size = al.size();
        if (size < k)
            return 0;
        if (k == size)
            return al.get(size - 1);
        return al.get(size - 1) / al.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */