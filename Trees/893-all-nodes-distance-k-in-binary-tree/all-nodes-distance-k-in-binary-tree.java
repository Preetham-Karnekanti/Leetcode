/**
 * Definition for a binary tree TreeNode.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode startNode;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentsMap = getParents(root, target);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startNode);
        HashSet<TreeNode> hs = new HashSet<>();
        hs.add(startNode);
        int distance = 0;
        while(!q.isEmpty()){
            if(distance == k)
                break;
            int size = q.size();
            while(size-- >0){
                TreeNode cur = q.poll();
                if(cur.left != null && !hs.contains(cur.left)){
                    hs.add(cur.left);
                    q.add(cur.left);
                }
                if(cur.right != null && !hs.contains(cur.right)){
                    hs.add(cur.right);
                    q.add(cur.right);
                }
                TreeNode parent = parentsMap.get(cur);
                if(parent!=null && !hs.contains(parent)){
                    q.add(parent);
                    hs.add(parent);
                }

            }
            distance++;
        }
        // int ans[] = new int[q.size()];
        // int i = 0;
        // while(!q.isEmpty()){
        //     ans[i++] = q.poll().data;
        // }
        // return ans;
        ArrayList<Integer> al = new ArrayList<>();
        while (!q.isEmpty()) {
            al.add(q.poll().val);
        }
        return al;
    }

   public   HashMap<TreeNode, TreeNode> getParents(TreeNode root, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.val == target.val)
                startNode = cur;
            if(cur.left != null){
                hm.put(cur.left, cur);
                q.add(cur.left);
            }
            if(cur.right != null){
                hm.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        return hm;
    }
}