class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m) {
        if (n == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> ret = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (String str : ret) {
            if (n != m)
                res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
            res.add("9" + str + "6");
        }
        return res;
    }
}