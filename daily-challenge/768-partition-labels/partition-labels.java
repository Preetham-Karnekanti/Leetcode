class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastOcc[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOcc[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            int right = lastOcc[s.charAt(i) - 'a'];
            int j = i;
            while (j < right) {
                right = Math.max(right, lastOcc[s.charAt(j) - 'a']);
                j++;
            }
            al.add(j - i + 1);
            i = j + 1;
        }
        return al;
    }
}