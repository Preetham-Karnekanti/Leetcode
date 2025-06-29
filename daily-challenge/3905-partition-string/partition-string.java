class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> hs = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        int left = 0;
        while (left < s.length()) {
            String temp = "" + s.charAt(left);
            int right = left + 1;
            while (hs.contains(temp) && right < s.length()) {
                temp += s.charAt(right);
                right++;
            }
            left = right;
            if (!hs.contains(temp))
                answer.add(temp);
            hs.add(temp);
        }
        return answer;
    }
}