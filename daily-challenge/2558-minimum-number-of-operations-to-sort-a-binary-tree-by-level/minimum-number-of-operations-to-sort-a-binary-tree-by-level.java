/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    al.add(node.left.val);
                    q.add(node.left);
                }
                if (node.right != null) {
                    al.add(node.right.val);
                    q.add(node.right);
                }
            }
            ans += findOps(al);
        }
        return ans;
    }

    public int findOps(ArrayList<Integer> al) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int arr[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
            hm.put(arr[i], i);
        }
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                int curPos = hm.get(temp[i]);
                hm.put(arr[i], curPos);
                swap(arr, i, curPos);
            }
        }
        return ans;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}