class Solution {
    public List<String> stringSequence(String target) {
        List<String> answer = new ArrayList<>();
        String typed = "";
        int i = 0;
        while (i < target.length()) {
            char start = 'a';
            while (target.charAt(i) != start) {
                answer.add(typed + start);
                start++;
            }
            typed += start;
            answer.add(typed);
            i++;
        }
        return answer;
    }
}