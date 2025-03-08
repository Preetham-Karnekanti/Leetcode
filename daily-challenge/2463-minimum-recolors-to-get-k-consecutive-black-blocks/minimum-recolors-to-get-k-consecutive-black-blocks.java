class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        int white = 0;
        int left = 0;
        for (int right = 0; right < k; right++) {
            if (blocks.charAt(right) == 'W')
                white++;
        }
        min = Math.min(min, white);
        for (int right = k; right < blocks.length(); right++) {
            if (blocks.charAt(left) == 'W')
                white--;
            if (blocks.charAt(right) == 'W')
                white++;
            min = Math.min(min, white);
            left++;
        }
        return min;
    }
}