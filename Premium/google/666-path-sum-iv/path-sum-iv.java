class Solution {
    public int pathSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = num % 10;
            num /= 10;
            map.put(num, value);
        }
        Queue<int[]> q = new LinkedList<>();
        int root = nums[0] / 10;
        q.add(new int[] { root, map.get(root) });
        int totalSum = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int coordinates = cur[0];
            int curSum = cur[1];
            int level = coordinates / 10;
            int position = coordinates % 10;
            int leftChild = (level + 1) * 10 + 2 * position - 1;
            int rightChild = (level + 1) * 10 + 2 * position;

            if (map.containsKey(leftChild) == false && map.containsKey(rightChild) == false)
                totalSum += curSum;
            if (map.containsKey(leftChild)) {
                q.add(new int[] { leftChild, curSum + map.get(leftChild) });
            }
            if (map.containsKey(rightChild)) {
                q.add(new int[] { rightChild, curSum + map.get(rightChild) });
            }

        }
        return totalSum;
    }
}