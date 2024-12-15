class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            double adiff = (a.pass + 1) / (a.total + 1) - (a.pass / a.total);
            double bdiff = (b.pass + 1) / (b.total + 1) - (b.pass / b.total);
            return Double.compare(bdiff, adiff);
        });
        for (int i = 0; i < classes.length; i++) {
            int pass = classes[i][0];
            int total = classes[i][1];
            pq.add(new Pair(pass, total));
        }
        while (extraStudents-- > 0) {
            Pair cur = pq.poll();
            cur.pass += 1;
            cur.total += 1;
            pq.add(cur);
        }
        double percentage = 0.0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            double pass = cur.pass;
            double total = cur.total;
            percentage += (pass / total);
        }
        return percentage / classes.length;
    }
}

class Pair {
    double pass;
    double total;

    Pair(double p, double t) {
        pass = p;
        total = t;
    }
}