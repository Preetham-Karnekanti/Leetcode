class LRUCache {

    int size;
    HashMap<Integer, Node> hm;
    DLL dll;

    public LRUCache(int capacity) {
        size = capacity;
        hm = new HashMap<>();
        dll = new DLL();
    }

    public int get(int key) {
        if (hm.get(key) == null)
            return -1;
        Node node = hm.get(key);
        dll.moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (hm.get(key) == null) {
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            dll.addFirst(newNode);
            if (hm.size() > size) {
                Node deleted = dll.removeTail();
                hm.remove(deleted.key);
            }
        } else {
            Node node = hm.get(key);
            node.value = value;
            dll.moveNodeToHead(node);
        }
    }
}

class Node {
    int value, key;
    Node next, prev;

    Node(int key, int data) {
        this.key = key;
        this.value = data;
        next = prev = null;
    }
}

class DLL {
    Node head, tail;

    DLL() {
        tail = head = null;
    }

    public void addFirst(Node node) {
        if (head == null && tail == null) {
            head = tail = node;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void moveNodeToHead(Node node) {
        if (head == node)
            return;
        if (node == tail) {
            Node prev = node.prev;
            prev.next = null;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            tail = prev;
            return;
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = head;
        head.prev = node;
        head = node;
    }

    public Node removeTail() {
        Node deletedTail = tail;
        tail = tail.prev;
        tail.next = null;
        return deletedTail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */