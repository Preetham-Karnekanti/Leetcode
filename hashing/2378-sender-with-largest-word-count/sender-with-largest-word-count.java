class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        String ans = "";
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for (int i = 0; i < messages.length; i++) {
            int len = messages[i].split(" ").length;
            hm.put(senders[i], hm.getOrDefault(senders[i], 0) + len);
            max = Math.max(max, hm.get(senders[i]));
        }
        
        for (String key : hm.keySet()) {
            if (hm.get(key) == max && ans.compareTo(key) < 0) {
                ans = key;
            }
        }

        return ans;
    }
}