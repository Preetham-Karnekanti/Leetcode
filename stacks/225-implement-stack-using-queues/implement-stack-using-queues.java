class MyStack {
    Queue<Integer> dq;

    public MyStack() {
        dq = new LinkedList<>();
    }

    public void push(int x) {
        dq.add(x);
    }

    public int pop() {
        int size = dq.size();
        for (int i = 1; i < size; i++) {
            dq.add(dq.remove());
        }
        return dq.remove();
    }

    public int top() {
        int size = dq.size();
        
        for (int i = 1; i < size; i++) {
            dq.add(dq.remove());
        }
        int val = dq.remove();
        dq.add(val);
        return val;
    }

    public boolean empty() {
        return dq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */