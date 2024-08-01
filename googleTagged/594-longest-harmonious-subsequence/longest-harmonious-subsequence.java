class Solution {
    public int findLHS(int[] arr) {
        int answer = 0;
        int n = arr.length;
        // HashMap to store the count of every element.
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        // Iterating over the array.
        for (int i = 0; i < n; i++) {
            // Increment the count of arr[i].
            int cnt = (frequency.containsKey(arr[i])) ? frequency.get(arr[i]) : 0;
            frequency.put(arr[i], cnt + 1);

            /*
             * If arr[i] + 1 is present, it means we can make a harmonic subsequence
             * using all the occurences of arr[i] and arr[i] + 1.
             */
            if (frequency.containsKey(arr[i] + 1)) {
                answer = Math.max(answer, frequency.get(arr[i]) + frequency.get(arr[i] + 1));

            }

            /*
             * If arr[i] - 1 is present, it means we can make a harmonic subsequence
             * using all the occurences of arr[i] and arr[i] - 1.
             */
            if (frequency.containsKey(arr[i] - 1)) {
                answer = Math.max(answer, frequency.get(arr[i]) + frequency.get(arr[i] - 1));
            }
        }

        return answer;
    }
}