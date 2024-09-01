class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int m : left) {
                    for (int n : right) {
                        if (ch == '-')
                            res.add(m - n);
                        else if (ch == '+')
                            res.add(m + n);
                        else
                            res.add(m * n);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.parseInt(expression));
        return res;
    }
}