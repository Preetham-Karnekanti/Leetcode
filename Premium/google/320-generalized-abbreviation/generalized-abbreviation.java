class Solution {
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> ans = new ArrayList<>();
        helper(word, ans, 0, 0, "");
        return ans;
    }
    public void helper(String word, ArrayList<String> ans, int idx, int count, String temp){
        if(idx == word.length()){
            if(count > 0)
                temp += count;
            ans.add(temp);
        }else{
            helper(word, ans, idx + 1, count + 1, temp);
            helper(word, ans, idx + 1, 0, temp + (count > 0 ? count : "") + word.charAt(idx));
        }
    }
}