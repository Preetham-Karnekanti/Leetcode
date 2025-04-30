class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (List<String> r : responses) {
            HashSet<String> hs = new HashSet<>();
            for (String s : r) {
                if (hs.contains(s))
                    continue;
                hm.put(s, hm.getOrDefault(s, 0) + 1);
                hs.add(s);
            }
        }
        int maxFreq = 0;
        String answer = "";
        for (String str : hm.keySet()) {
            if (hm.get(str) > maxFreq) {
                maxFreq = hm.get(str);
                answer = str;
            } else if (hm.get(str) == maxFreq) {
                if (answer.compareTo(str) > 0) {
                    answer = str;
                }
            }
        }
        return answer;
    }
}