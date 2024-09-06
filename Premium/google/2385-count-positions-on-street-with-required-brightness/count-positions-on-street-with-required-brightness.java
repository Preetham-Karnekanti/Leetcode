class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int prefix[] = new int[n];
        for (int l[] : lights) {
            int i = l[0];
            int range = l[1];
            int left = Math.max(0, i - range);
            int right = Math.min(n - 1, i + range);
            prefix[left]++;
            if (right < n - 1)
                prefix[right + 1]--;
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        int count = 0;
        System.out.println(Arrays.toString(prefix));
        for (int i = 0; i < n; i++) {
            if (prefix[i] >= requirement[i])
                count++;
        }
        return count;
    }
}