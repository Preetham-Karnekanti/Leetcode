class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(s);
        }

        return new ArrayList<>(hm.values());
    }
}