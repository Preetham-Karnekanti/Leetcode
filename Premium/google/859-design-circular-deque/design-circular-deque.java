class MyCircularDeque {
    Node head;
    Node tail;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        head = null;
        tail = null;
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        } else {
            Node newHead = new Node(value);
            newHead.next = head;
            newHead.prev = tail;
            tail.next = newHead;
            head.prev = newHead;
            head = newHead;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        Node newTail = new Node(value);
        if (head == null) {
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            newTail.next = head;
            newTail.prev = tail;
            head.prev = tail;
            tail = newTail;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        size--;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        size--;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return head.val;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

class Node {
    int val;
    Node prev, next;

    Node(int v) {
        val = v;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */