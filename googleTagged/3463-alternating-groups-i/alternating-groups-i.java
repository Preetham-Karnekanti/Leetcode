class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == colors[(i + 2) % n] && colors[i] != colors[(i + 1) % n]) {
                count++;
            }
        }
        return count;
    }
}