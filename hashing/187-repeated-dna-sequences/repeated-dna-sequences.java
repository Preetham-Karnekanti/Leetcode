class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 9)
            return new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int left = 0;
        for (int right = 9; right < s.length(); right++) {
            String str = s.substring(left, right + 1);
            hm.put(str, hm.getOrDefault(str, 0) + 1);
            left++;
        }
        ArrayList<String> al = new ArrayList<>();
        for (String key : hm.keySet()) {
            int val = hm.get(key);
            if (val > 1)
                al.add(key);
        }
        return al;
    }
}