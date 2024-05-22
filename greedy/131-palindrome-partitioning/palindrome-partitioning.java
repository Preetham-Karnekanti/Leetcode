class Solution {
    List<List<String>> al;

    public List<List<String>> partition(String s) {
        al = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return al;
    }

    public void helper(String s, int idx, ArrayList<String> temp) {
        if (idx >= s.length()) {
            al.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            if (isPallindrome(s, idx, i)) {
                temp.add(s.substring(idx, i + 1));
                helper(s, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPallindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}