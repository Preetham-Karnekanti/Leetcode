class Solution {
    public String maximumNumber(String num, int[] change) {
        int right = 0;
        char[] arr = num.toCharArray();
        for (right = 0; right < num.length(); right++) {
            int cur = num.charAt(right) - '0';
            if (cur < change[cur]) {
                while (right < arr.length && (arr[right] - '0' <= change[arr[right] - '0'])) {
                    arr[right] = (char) (change[arr[right] - '0'] + '0');
                    right++;
                }
                break;
            }
        }
        return new String(arr);
    }
}