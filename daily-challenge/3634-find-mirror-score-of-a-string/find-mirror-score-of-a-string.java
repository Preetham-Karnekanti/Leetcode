class Solution {
    public long calculateScore(String s) {
        long ans = 0;
        String mirror = "zyxwvutsrqponmlkjihgfedcba";
        HashMap<Character, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            char mirrorChar = mirror.charAt(ch-'a');
            PriorityQueue<Integer> pq = hm.getOrDefault(mirrorChar, new PriorityQueue());
            hm.putIfAbsent(ch, new PriorityQueue<>((a,b)-> b-a));
           if(pq.isEmpty()){
            hm.get(ch).add(i);
            continue;
           }
           ans += (i - pq.poll());
        }
        return ans;
    }
}