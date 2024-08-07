class Solution {
    public boolean validWordSquare(List<String> words) {
        HashMap<Integer, String> hm = new HashMap<>();
        HashMap<Integer, String> hm1 = new HashMap<>();
        for (int i = 0; i < words.size(); i++)
            hm.put(i, words.get(i));
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                String temp = hm1.getOrDefault(j, "");
                temp += words.get(i).charAt(j);
                hm1.put(j, temp);
            }
        }
        return hm.equals(hm1);
    }
}