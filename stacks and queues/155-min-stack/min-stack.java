class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        long x = val;
        if (st.isEmpty()) {
            st.push(x);
            min = x;
            return;
        }
        if (val >= min) {
            st.push(x);
            return;
        }
        long value = 2 * x - min;
        st.push(value);
        min = x;
    }

    public void pop() {
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        if (st.peek() < min)
            return (int)min;
        return  st.peek().intValue();
    }

    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */