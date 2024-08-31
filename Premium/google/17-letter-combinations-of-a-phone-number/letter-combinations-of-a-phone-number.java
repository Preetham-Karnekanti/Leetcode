class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> al = new ArrayList<>();
        if (digits.equals("")) {
            return al;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(al, map, 0, digits, "");
        return al;
    }

    public void helper(List<String> al, HashMap<Character, String> hm, int idx, String s, String temp) {
        if (idx >= s.length()) {
            al.add(temp);
            return;
        }
        for (int i = 0; i < hm.get(s.charAt(idx)).length(); i++) {
            char ch = hm.get(s.charAt(idx)).charAt(i);
            helper(al, hm, idx + 1, s, temp + ch);
        }
    }
}