class ThroneInheritance {
    Node root;
    HashMap<String, Node> map;

    public ThroneInheritance(String kingName) {
        root = new Node(kingName);
        map = new HashMap<>();
        map.put(kingName, root);
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName);
        parent.children.add(child);
        map.put(childName, child);

    }

    public void death(String name) {
        map.get(name).isDead = true;
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> al = new ArrayList<>();
        preorderTraversal(root, al);
        return al;
    }

    public void preorderTraversal(Node curr, ArrayList<String> al) {
        if (curr == null)
            return;
        if (curr.isDead == false)
            al.add(curr.name);
        for (Node n : curr.children) {
            preorderTraversal(n, al);
        }
    }
}

class Node {
    ArrayList<Node> children;
    String name;
    boolean isDead;

    Node(String name) {
        this.name = name;
        isDead = false;
        children = new ArrayList<>();
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */