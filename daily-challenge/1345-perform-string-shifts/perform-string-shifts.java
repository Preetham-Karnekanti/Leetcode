class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> q = new ArrayDeque();
        int n = s.length();
        for (int i = 0; i < s.length(); i++)
            q.add(s.charAt(i));
        for(int ops[]: shift){
            int direction = ops[0];
            int k = ops[1] % n;
            for(int i = 0;i<k;i++){
                if(direction == 0){
                    q.addLast(q.pollFirst());
                }else{
                    q.addFirst(q.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll());
        }
        return sb.toString();
    }
}