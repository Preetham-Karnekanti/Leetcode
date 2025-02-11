class Solution {
    public String removeOccurrences(String s, String part) {
        if (s.contains(part) == false)
            return s;
        else {
            int idx = s.indexOf(part);
            return removeOccurrences(s.substring(0, idx) + s.substring(idx + part.length()), part);
        }
    }
}