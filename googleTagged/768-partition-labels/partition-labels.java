class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastOcc[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOcc[s.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int max = lastOcc[s.charAt(i) - 'a'];
            while (j < max) {
                max = Math.max(max, lastOcc[s.charAt(j) - 'a']);
                j++;
            }
            al.add(j - i + 1);
            i = j;
        }
        return al;
    }
}