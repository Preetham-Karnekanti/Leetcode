class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        int max = 0;
        for (int i = 0; i < pairs.length; i++) {
            int prev[] = pairs[i];
            int count = 1;
            for (int j = i + 1; j < pairs.length; j++) {
                if(prev[1] < pairs[j][0]){
                    count++;
                    prev = pairs[j];
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}