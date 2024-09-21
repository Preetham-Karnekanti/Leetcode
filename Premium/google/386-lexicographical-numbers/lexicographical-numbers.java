class Solution {
    public List<Integer> lexicalOrder(int n) {
        Trie t = new Trie();
        for (int i = 1; i <= n; i++) {
            t.insert(String.valueOf(i));
        }
        ArrayList<Integer> answer = new ArrayList<>();
        t.dfs(answer);
        return answer;
    }
}

class Node {
    Node children[];
    boolean isEnd;

    Node() {
        children = new Node[10];
        isEnd = false;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String num) {
        Node temp = root;
        for (int i = 0; i < num.length(); i++) {
            int idx = num.charAt(i) - '0';
            if (temp.children[idx] == null)
                temp.children[idx] = new Node();
            temp = temp.children[idx];
        }
        temp.isEnd = true;
    }

    public void dfs(ArrayList<Integer> al) {
        Node temp = root;
        dfsUtil(temp, al, 0);
    }

    public void dfsUtil(Node temp, ArrayList<Integer> al, int number) {
        for (int i = 0; i < 10; i++) {
            if (temp.children[i] != null) {
                if (temp.children[i].isEnd) {
                    al.add(number * 10 + i);
                }
                dfsUtil(temp.children[i], al, number * 10 + i);
            }
        }
    }
}