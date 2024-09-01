class Solution {
    int target;
    String digits;
    List<String> answer;

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0)
            return new ArrayList<>();
        this.target = target;
        this.digits = num;
        answer = new ArrayList<>();
        helper(0, 0, 0, 0, new ArrayList<>());
        return answer;
    }

    public void helper(int idx, long previous, long current, long value, ArrayList<String> ops) {
        if (idx == digits.length()) {
            if (value == target && current == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < ops.size(); i++) {
                    sb.append(ops.get(i));
                }
                answer.add(sb.toString());
            }
            return;
        }

        current = current * 10 + (digits.charAt(idx) - '0');
        String currentNumber = String.valueOf(current);
        if (current > 0) {
            helper(idx + 1, previous, current, value, ops);
        }
        ops.add("+");
        ops.add(currentNumber);
        helper(idx + 1, current, 0, value + current, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            ops.add("-");
            ops.add(currentNumber);
            helper(idx + 1, -current, 0, value - current, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            ops.add("*");
            ops.add(currentNumber);
            helper(idx + 1, current * previous, 0, value - previous + (previous * current), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }
}