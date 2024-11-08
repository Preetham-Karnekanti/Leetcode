class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                al.add(arr1[i]);
            } 
            int minVal = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
            if (arr1[i] == minVal) i++;
            if (arr2[j] == minVal) j++;
            if (arr3[k] == minVal) k++;
        }
        return al;
    }
}