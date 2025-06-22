class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> al = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            StringBuilder cur = new StringBuilder();
            int count = 0;
            while (i < s.length() && count < k) {
                cur.append(s.charAt(i));
                count++;
                i++;
            }
            while (cur.length() < k) {
                cur.append(fill);
            }
            al.add(cur.toString());
        }

        return al.toArray(new String[0]);
    }
}