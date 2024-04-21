class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int arr[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                    arr[st.pop()] = 1;
                    arr[i] = 1;
                } else
                    st.push(i);
            }
        }

        max = findMaxConscecutiveOnes(arr);
        return max;
    }

    public int findMaxConscecutiveOnes(int[] arr) {
        int i = 0;
        int max = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
            i++;
        }
        max = Math.max(max, count);
        return max;
    }
}