class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int j = 0; j < s; j++) {
                int curr = q.poll();
                for (int i = 1; i <= nums[curr]; i++) {
                    if (curr + i >= nums.length - 1)
                        return ++level;
                    if (set.add(curr + i))
                        q.add(curr + i);
                }
            }
            level++;
        }
        return 0;
    }
}