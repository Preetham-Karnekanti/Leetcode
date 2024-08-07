class MovingAverage {

    double sum, size;
    Queue<Double> q;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        double value = val;
        sum += value;
        q.add(value);
        if (q.size() > size) {
            sum -= q.poll();
        }
        return sum / (double) q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */