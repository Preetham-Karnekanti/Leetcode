class Solution {
    public int findLHS(int[] arr) {
        int answer = 0;
        int n = arr.length;
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);

            if (frequency.containsKey(arr[i] + 1)) {
                answer = Math.max(answer, frequency.get(arr[i]) + frequency.get(arr[i] + 1));
            }

            if (frequency.containsKey(arr[i] - 1)) {
                answer = Math.max(answer, frequency.get(arr[i]) + frequency.get(arr[i] - 1));
            }
        }

        return answer;
    }
}