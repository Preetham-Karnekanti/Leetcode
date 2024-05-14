class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.score == b.score)
                return b.id - a.id;
            return a.score - b.score;
        });
        HashMap<String, Integer> feedback = new HashMap<>();
        for (String s : positive_feedback) {
            feedback.put(s, 3);
        }
        for (String s : negative_feedback) {
            feedback.put(s, -1);
        }
        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            int score = 0;
            for (String s : str) {
                score += feedback.getOrDefault(s, 0);
            }
            pq.add(new Pair(student_id[i], score));
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll().id);
        }
        Collections.reverse(ans);
        return ans;
    }
}

class Pair{
    int id;
    int score;
    Pair(int id, int score){
        this.id = id;
        this.score =score;
    }
}