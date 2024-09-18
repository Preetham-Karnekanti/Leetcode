class Solution {
    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] + "";
            sum += nums[i];
        }
        if (sum == 0)
            return "0";
        Arrays.sort(temp, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}