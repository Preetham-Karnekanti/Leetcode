class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length - 1;
        int tempA = capacityA;
        int tempB = capacityB;
        int countA = 0;
        int countB = 0;
        System.out.println(plants.length);
        while (i < j) {
            if (tempA >= plants[i]) {
                tempA -= plants[i];
            } else {
                countA++;
                tempA = capacityA - plants[i];
            }
            if (i < j) {
                if (tempB >= plants[j]) {
                    tempB -= plants[j];
                } else {
                    countB++;
                    tempB = capacityB - plants[j];
                }
            }
            i++;
            j--;
        }
        if (i == j) {
            if (tempA >= tempB) {
                if (tempA < plants[i])
                    countA++;
            } else {
                if (tempB < plants[i])
                    countB++;
            }
        }
        return countA + countB;
    }
}