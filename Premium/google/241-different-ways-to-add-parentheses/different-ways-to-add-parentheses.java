class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int n : left) {
                    for (int m : right) {
                        if (ch == '-')
                            results.add(n - m);
                        else if (ch == '+')
                            results.add(m + n);
                        else
                            results.add(m * n);
                    }
                }
            }
        }
        if (results.size() == 0)
            results.add(Integer.parseInt(expression));
        return results;
    }
}