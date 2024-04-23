class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    ListNode dummyhead;
    int size;

    public MyLinkedList() {
        this.dummyhead = new ListNode(0, null);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }
        int count = 0;
        ListNode temp = dummyhead.next;
        while (temp != null) {
            if (count == index)
                return temp.val;
            count++;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        this.dummyhead.next = new ListNode(val, this.dummyhead.next);
        this.size++;
    }

    public void addAtTail(int val) {
        ListNode cur = this.dummyhead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val, null);
        this.size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            return;
        }

        ListNode cur = this.dummyhead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new ListNode(val, cur.next);
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        ListNode cur = this.dummyhead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        this.size--;
    }
}