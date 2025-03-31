class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int greater[] = new int[nums2.length];
        Arrays.fill(greater, -1);
        HashMap<Integer, Integer> hm = new HashMap();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                greater[st.peek()] = nums2[i];
                st.pop();
            }
            st.push(i);
            hm.put(nums2[i], i);
        }
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greater[hm.get(nums1[i])];
        }
        return ans;
    }
}