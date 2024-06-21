class Solution {
    public List<Integer> lexicalOrder(int n) {
        Trie t = new Trie();
        for (int i = 1; i <= n; i++) {
            t.insert(i);
        }
        ArrayList<Integer> al = new ArrayList<>();
        t.dfs(al);
        return al;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(int n) {
        Node temp = root;
        String sb = String.valueOf(n);
        for (int i = 0; i < sb.length(); i++) {
            int idx = sb.charAt(i) - '0';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new Node();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public void dfs(ArrayList<Integer> al) {
        Node temp = root;
        dfsUtil(al, temp, 0);
    }

    public void dfsUtil(ArrayList<Integer> al, Node temp, int number) {
        for (int i = 0; i < 10; i++) {
            if (temp.arr[i] != null) {
                if (temp.arr[i].isEnd) {
                    al.add(number * 10 + i);
                }
                dfsUtil(al, temp.arr[i], number * 10 + i);
            }
        }
    }
}

class Node {
    Node arr[];
    boolean isEnd;

    Node() {
        arr = new Node[10];
        isEnd = false;
    }
}