class Solution {

    Boolean isLeaf(TreeNode root, List<Integer> leafs) {
        // base case
        if (root == null) {
            return false;
        }

        // best case
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
            return true;
        }

        if (isLeaf(root.left, leafs)) {
            root.left = null;
        }
        if (isLeaf(root.right, leafs)) {
            root.right = null;
        }

        return false;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        boolean allDone = false;
        List<List<Integer>> result = new ArrayList<>();
        while (!allDone) {

            List<Integer> curr = new ArrayList<>();
            allDone = isLeaf(root, curr);
            result.add(curr);

        }

        return result;
    }
}