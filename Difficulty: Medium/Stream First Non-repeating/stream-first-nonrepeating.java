class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        int freq[] = new int[26];
        StringBuilder answer = new StringBuilder();
        answer.append(s.charAt(0));
        freq[s.charAt(0)-'a']++;
        Queue<Character> q = new LinkedList<>();
        q.add(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            if(freq[s.charAt(i)-'a'] == 1)
                q.add(s.charAt(i));
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.poll();
            }
            if(q.isEmpty()) answer.append('#');
            else answer.append(q.peek());
        }
        return answer.toString();
    }
}