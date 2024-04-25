class LRUCache {

    HashMap<Integer, Node> hm;
    Node head, tail;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = null;
        tail = null;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (hm.containsKey(key) == false)
            return -1;
        Node currNode = hm.get(key);
        moveNodeToFirst(currNode, currNode.val);
        return currNode.val;
    }

    public void put(int key, int value) {
        if (size == 0) {
            Node newNode = new Node(key, value);
            head = tail = newNode;
            size++;
            hm.put(key, newNode);
            return;
        }
        if (hm.containsKey(key)) {
            moveNodeToFirst(hm.get(key), value);
        } else {
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            addNodeAtFirst(newNode);
        }
        if (size > capacity) {
            removeTail();
            size--;
        }
    }

    public void moveNodeToFirst(Node currNode, int value) {
        currNode.val = value;
        if (currNode == head)
            return;
        if (currNode == tail) {

            Node prev = currNode.prev;
            prev.next = null;
            currNode.prev = null;
            currNode.next = head;
            head.prev =currNode;
            head = currNode;
            tail = prev;
            return;
        }
        Node prev = currNode.prev;
        Node next = currNode.next;
        prev.next = next;
        next.prev = prev;
        currNode.next = head;
        head.prev = currNode;
        head = currNode;
    }

    public void addNodeAtFirst(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
        size++;
        return;
    }

    public void removeTail() {
        hm.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
        return;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.val = value;
        next = null;
        prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */