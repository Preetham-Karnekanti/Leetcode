class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int temp = capacity;
        int steps = 1;
        temp = temp - plants[0];
        for (int i = 1; i < plants.length; i++) {
            if (temp >= plants[i]) {
                temp -= plants[i];
                steps++;
            } else {
                steps = steps + i + (i + 1);
                temp = capacity - plants[i];
            }
        }
        return steps;
    }
}