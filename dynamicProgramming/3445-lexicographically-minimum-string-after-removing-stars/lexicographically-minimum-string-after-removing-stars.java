class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch == b.ch)
                return b.idx - a.idx;
            return a.ch - b.ch;
        });
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*')
                pq.add(new Pair(s.charAt(i), i));
            else {
                pq.poll();
            }
        }
        ArrayList<Pair> al = new ArrayList<>();
        while (!pq.isEmpty())
            al.add(pq.poll());
        Collections.sort(al, (a, b) -> a.idx - b.idx);
        String ans = "";
        for (int i = 0; i < al.size(); i++)
            ans += al.get(i).ch;
        return ans;
    }
}

class Pair {
    char ch;
    int idx;

    Pair(char ch, int idx) {
        this.ch = ch;
        this.idx = idx;
    }
}