class PhoneDirectory {

    Queue<Integer> q;
    HashSet<Integer> hs;

    public PhoneDirectory(int maxNumbers) {
        q = new LinkedList<>();
        hs = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++)
            q.add(i);
    }

    public int get() {
        if (q.size() == 0)
            return -1;
        hs.add(q.peek());
        return q.poll();
    }

    public boolean check(int number) {
        return !hs.contains(number);
    }

    public void release(int number) {
        if (!hs.contains(number))
            return;
        hs.remove(number);
        q.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */