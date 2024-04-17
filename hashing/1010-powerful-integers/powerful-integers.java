class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int a = (int) (Math.log(bound) / Math.log(x));
        int b = (int) (Math.log(bound) / Math.log(y));
        if (a == Integer.MAX_VALUE)
            a = 0;
        if (b == Integer.MAX_VALUE)
            b = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int sum = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (sum > bound)
                    break;
                hs.add(sum);
            }
        }
        return new ArrayList<>(hs);
    }
}