class Pair{
    StringBuilder str;
    TreeNode root;
    public Pair(StringBuilder str, TreeNode root){
        this.str = str;
        this.root = root;
    }
}
class Solution {
    HashMap<TreeNode, TreeNode> parent;
    TreeNode src;
    HashSet<Integer> visited;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        parent = new HashMap<>();
        src = null;
        visited = new HashSet<>();
        inorder(root, null, startValue);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(new StringBuilder(""), src));
        visited.add(src.val);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair pair = queue.remove();
                TreeNode node = pair.root;
                StringBuilder str = pair.str;  
                if(node.left != null && !visited.contains(node.left.val)){
                    StringBuilder dummy = new StringBuilder(str);
                    dummy.append("L");
                    visited.add(node.val);
                    if(node.left.val == destValue)
                        return dummy.toString();
                    queue.add(new Pair(dummy, node.left));
                }
                if(node.right != null && !visited.contains(node.right.val)){
                    StringBuilder dummy = new StringBuilder(str);
                    dummy.append("R");
                    visited.add(node.val);
                    if(node.right.val == destValue)
                        return dummy.toString();
                    queue.add(new Pair(dummy, node.right));
                }
                if(parent.get(node) != null && !visited.contains(parent.get(node).val)){
                    StringBuilder dummy = new StringBuilder(str);
                    dummy.append("U");
                    visited.add(parent.get(node).val);
                    if(parent.get(node).val == destValue)
                        return dummy.toString();
                    queue.add(new Pair(dummy, parent.get(node)));
                }
            }
        }
        return "";
    }

        
    public void inorder(TreeNode root, TreeNode par, int startVal){
        if(root == null)
            return;
        if(root.left != null)
            inorder(root.left, root, startVal);
        parent.put(root, par);
        if(root.val == startVal)
            src = root;
        if(root.right != null)
            inorder(root.right, root, startVal);
    }
}