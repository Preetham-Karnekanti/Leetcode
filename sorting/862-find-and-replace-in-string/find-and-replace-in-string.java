class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        Triplet[] ordered = new Triplet[k];
        boolean[] contains = new boolean[k];
        for (int i = 0; i < indices.length; i++) {
            ordered[i] = new Triplet(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(ordered, (a, b) -> a.idx - b.idx);
        int strLen = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int idx = ordered[i].idx;
            String source = ordered[i].source;
            String target = ordered[i].target;
            contains[i] = (idx + source.length() <= s.length())
                    && s.substring(idx, idx + source.length()).equals(source);
        }
        int prevIdx = 0;
        for (int i = 0; i < k; i++) {
            if (contains[i]) {
                sb.append(s.substring(prevIdx, ordered[i].idx));
                sb.append(ordered[i].target);
                prevIdx = ordered[i].idx + ordered[i].source.length();
            }
        }
        sb.append(s.substring(prevIdx));
        return sb.toString();
    }
}

class Triplet {
    int idx;
    String source;
    String target;

    Triplet(int idx, String source, String target) {
        this.idx = idx;
        this.source = source;
        this.target = target;
    }
}