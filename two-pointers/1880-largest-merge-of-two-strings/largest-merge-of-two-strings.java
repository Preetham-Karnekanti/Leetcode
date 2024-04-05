class Solution {
    public String largestMerge(String word1, String word2) {
        char w1[] = word1.toCharArray();
        char w2[] = word2.toCharArray();
        int j = 0;
        int i = 0;
        int n = w1.length;
        int m = w2.length;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            if (w1[i] > w2[j])
                sb.append(w1[i++]);
            else if (w1[i] < w2[j])
                sb.append(w2[j++]);
            else{
                String s = word1.substring(i+1);
                String s1 = word2.substring(j+1);
                if(s.compareTo(s1) > 0)
                    sb.append(w1[i++]);
                else
                    sb.append(w2[j++]);
            }
               
        }
        while (i < n)
            sb.append(w1[i++]);
        while (j < m)
            sb.append(w2[j++]);
        return sb.toString();
    }
}