class MyCircularDeque {

    Node head, tail;
    int size, currSize;

    public MyCircularDeque(int k) {
        size = k;
        head = null;
        tail = null;
        currSize = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        currSize++;
        Node n = new Node(value);
        if (head == null) {
            head = tail = n;
            return true;
        }
        n.next = head;
        head.prev = n;
        head = n;
        head.prev = tail;
        tail.next = head;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        currSize++;
        Node n = new Node(value);
        if (head == null) {
            head = tail = n;
            return true;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
        head.prev = tail;
        tail.next = head;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        currSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        currSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return tail.data;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public boolean isFull() {
        if (currSize == size)
            return true;
        return false;
    }
}

class Node {
    Node next;
    Node prev;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
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