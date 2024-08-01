class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minimunOperations = blocks.length();
        int left = 0;
        int white = 0;
        for (int right = 0; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W')
                white++;
            while (right - left + 1 > k) {
                if (blocks.charAt(left) == 'W')
                    white--;
                left++;
            }
            if (right - left + 1 == k)
                minimunOperations = Math.min(minimunOperations, white);
        }
        return minimunOperations;
    }
}