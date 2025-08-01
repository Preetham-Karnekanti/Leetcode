class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = answer.get(i - 1);
            for (int k = 0; k < prev.size() - 1; k++) {
                int sum = prev.get(k) + prev.get(k + 1);
                temp.add(sum);
            }
            temp.add(1);
            answer.add(temp);
        }
        return answer;
    }
}