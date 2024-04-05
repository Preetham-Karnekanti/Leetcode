class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refill = 0;
        int left = 0;
        int right = plants.length - 1;
        int temp1 = capacityA;
        int temp2 = capacityB;
        while (left < right) {
            if (temp1 < plants[left]) {
                refill++;
                temp1 = capacityA;
            }
            if (temp2 < plants[right]) {
                refill++;
                temp2 = capacityB;
            }
            temp1 -= plants[left];
            temp2 -= plants[right];
            left++;
            right--;
        }
        if (left == right) {
            if (Math.max(temp1, temp2) < plants[left]) {
                refill++;
            }
        }
        return refill;
    }
}