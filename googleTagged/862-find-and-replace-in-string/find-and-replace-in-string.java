class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            String str = s.substring(indices[i]);
            if (str.startsWith(sources[i]))
                hm.put(indices[i], i);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (!hm.containsKey(i)) {
                sb.append(s.charAt(i));
                i++;
            } else {
                sb.append(targets[hm.get(i)]);
                i += sources[hm.get(i)].length();
            }
        }
        return sb.toString();
    }
}