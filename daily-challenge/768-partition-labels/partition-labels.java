class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int maxIdx = last[s.charAt(i) - 'a'];
            int j = i;
            while (j < s.length() && j < maxIdx) {
                maxIdx = Math.max(maxIdx, last[s.charAt(j) - 'a']);
                j++;
            }
            answer.add(j - i + 1);
            i = j;
            i++;
        }
        return answer;
    }
}