class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        int distance = 0;

        while (i < arr1.length) {

            while (j < arr2.length &&
                   arr2[j] < arr1[i] - d) {
                j++;
            }

            if (j == arr2.length ||
                arr2[j] > arr1[i] + d) {
                distance++;
            }

            i++;
        }

        return distance;
    }
}