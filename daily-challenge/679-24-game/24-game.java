class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> arr = new ArrayList<>();
        for (int i = 0; i < cards.length; i++)
            arr.add((double)cards[i]);
        return helper(arr);
    }

    public boolean helper(List<Double> arr) {
        if (arr.size() == 1) {
            if (Math.abs(arr.get(0) - 24.0) < 0.1)
                return true;
            return false;
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                List<Double> poss = generate(arr.get(i), arr.get(j));
                for (Double c : poss) {
                    List<Double> next = new ArrayList<>();
                    next.add(c);
                    for (int k = 0; k < arr.size(); k++) {
                        if (k != i && k != j)
                            next.add(arr.get(k));
                    }
                    if(helper(next))
                        return true;
                }
            }
        }
        return false;
    }
    private List<Double> generate(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        res.add(a / b);
        res.add(b / a);
        return res;
    }
}