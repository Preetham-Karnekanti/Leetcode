class Solution {
    public int[] findPermutation(String s) {
        int res[] = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (i < s.length() && s.charAt(i) == 'D')
                i++;
            reverse(res, j, i);
            i++;
        }
        return res;
    }

    public void reverse(int res[], int i, int j) {
        while (i < j) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
    }
}