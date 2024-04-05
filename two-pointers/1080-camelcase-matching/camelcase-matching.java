class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> al = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            al.add(isSubSequence(queries[i], pattern));
        }
        return al;
    }

    public boolean isSubSequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n)
            return false;
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else if (ch1[i] >= 'A' && ch1[i] <= 'Z') {
                return false;
            } else
                i++;
        }
        if (j < m)
            return false;
        while (i < n) {
            if (ch1[i] >= 'A' && ch1[i] <= 'Z')
                return false;
            i++;
        }
        return true;
    }
}