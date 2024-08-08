class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String str : strings) {
            String key = getRelativeDistance(str);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>(hm.values());
        return ans;
    }

    public String getRelativeDistance(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append((int) (str.charAt(i) - str.charAt(0) + 26) % 26);
            sb.append(":");
        }
        return sb.toString();
    }
}