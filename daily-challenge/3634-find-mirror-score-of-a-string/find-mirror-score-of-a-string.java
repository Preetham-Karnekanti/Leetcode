class Solution {
    public long calculateScore(String s) {
        long ans = 0;
        String mirror = "zyxwvutsrqponmlkjihgfedcba";
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            char mirrorChar = mirror.charAt(ch-'a');
            List<Integer> pq = hm.getOrDefault(mirrorChar, new ArrayList());
            hm.putIfAbsent(ch, new ArrayList<>());
           if(pq.isEmpty()){
            hm.get(ch).add(i);
            continue;
           }
           ans += (i - pq.get(pq.size()-1));
           pq.remove(pq.size()-1);
        }
        return ans;
    }
}