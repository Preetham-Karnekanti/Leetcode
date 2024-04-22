class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st1 = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st1.isEmpty() && nums[st1.peek()] < nums[i]) {
                ans[st1.peek()] = nums[i];
                st1.pop();
            }
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                temp.push(st.pop());
            }
            while (!temp.isEmpty()) {
                st1.push(temp.pop());
            }
            st.push(i);
        }

        return ans;
    }
}