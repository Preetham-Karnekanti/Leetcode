class ZeroEvenOdd {
    private int n;
    private boolean isZeroTurn;
    private int current;

    public ZeroEvenOdd(int n) {
        this.n = n;
        isZeroTurn = true;
        current = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!isZeroTurn) {
                wait();
            }
            printNumber.accept(0);
            isZeroTurn = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {

            while (isZeroTurn || current % 2 == 1)
                wait();
            printNumber.accept(current);
            current++;
            isZeroTurn = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {

            while (isZeroTurn || current % 2 == 0)
                wait();
            printNumber.accept(current);
            current++;
            isZeroTurn = true;
            notifyAll();
        }
    }
}