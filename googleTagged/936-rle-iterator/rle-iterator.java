class RLEIterator {
    int idx = 0;
    int nums[];

    public RLEIterator(int[] encoding) {
        idx = 0;
        nums = encoding;
    }

    public int next(int n) {
        while (idx < nums.length) {
            if (nums[idx] >= n) {
                nums[idx] -= n;
                return nums[idx + 1];
            } else {
                n -= nums[idx];
                idx += 2;
            }
        }
        return -1;
    }

}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */