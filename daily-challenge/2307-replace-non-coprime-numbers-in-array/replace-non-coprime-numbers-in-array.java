class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!st.isEmpty() && GCD(num, st.peek()) > 1) {
                int top = st.pop();
                int gcd = GCD(num, top);
                int lcm = (int)((long)top / gcd * num);
                num = lcm;
            }
            st.push(num);
        }
        return new ArrayList<>(st);
    }

    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}