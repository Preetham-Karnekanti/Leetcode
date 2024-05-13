class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());
        if (hm.get(pq.peek()) > (s.length() + 1) / 2)
            return "";
        char[] result = new char[s.length()];
        int i = 0;
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int freq = hm.get(c);
            for (int j = 0; j < freq; j++) {
                if (i >= s.length())
                    i = 1;
                result[i] = c;
                i += 2;
            }
        }
        return new String(result);
    }
}