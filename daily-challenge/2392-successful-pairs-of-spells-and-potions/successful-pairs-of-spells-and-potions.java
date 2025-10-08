class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int answer[] = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int idx = search(potions, spells[i], success);
            if (idx != -1) {
                answer[i] = potions.length - idx;
            }
        }
        return answer;
    }

    public int search(int[] potions, long spell, long success) {
        int low = 0;
        int high = potions.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long product = (long) potions[mid] * spell;
            if (product < success) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}