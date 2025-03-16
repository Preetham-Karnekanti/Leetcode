public class ZigzagIterator {

    private Queue<Integer> q;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        
        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) q.offer(it1.next());
            if (it2.hasNext()) q.offer(it2.next());
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}