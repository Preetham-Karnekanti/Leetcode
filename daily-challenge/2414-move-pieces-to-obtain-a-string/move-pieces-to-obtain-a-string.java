class Solution {
    public boolean canChange(String start, String target) {
        int length = start.length();

        int i = 0;
        int j = 0;
        while (i < length || j < length) {
            while (i < length && start.charAt(i) == '_')
                i++;
            while (j < length && target.charAt(j) == '_')
                j++;
            if (i == length || j == length)
                return i == length && j == length;
            if (start.charAt(i) != target.charAt(j) || (start.charAt(i) == 'L' && i < j)
                    || (start.charAt(i) == 'R' && i > j))
                return false;
            i++;
            j++;
        }
        return true;
    }
}