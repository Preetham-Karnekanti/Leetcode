class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            al.add(i);
        }
        al.add(n);
        k = k - 1;
        String ans = "";
        while (true) {
            ans += al.get(k / fact);
            al.remove(k / fact);
            if (al.size() == 0)
                return ans;
            k = k % fact;
            fact /= al.size();
        }
    }
}