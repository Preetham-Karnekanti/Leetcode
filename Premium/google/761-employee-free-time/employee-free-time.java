/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        ArrayList<Interval> all = new ArrayList<>();
        ArrayList<Interval> res = new ArrayList<>();
        for (List<Interval> list : schedule) {
            for (Interval i : list) {
                all.add(i);
            }
        }
        Collections.sort(all, (a, b) -> a.start - b.start);
        int curEnd = all.get(0).end;
        for (int i = 1; i < all.size(); i++) {
            if (curEnd < all.get(i).start) {
                res.add(new Interval(curEnd, all.get(i).start));
            }
            curEnd = Math.max(curEnd, all.get(i).end);
        }
        return res;
    }
}