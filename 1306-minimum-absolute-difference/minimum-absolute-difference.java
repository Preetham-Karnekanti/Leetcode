class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        //Sorting the arraylist
        Arrays.sort(arr);

        //Initalizing the Minimum diffrence variable
        int minDiff = Integer.MAX_VALUE;

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}