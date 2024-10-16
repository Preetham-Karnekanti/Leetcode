/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 * public InfiniteStream(int[] bits);
 * public int next();
 * }
 */
class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        StringBuilder patternBuilder = new StringBuilder();
        for (int i : pattern)
            patternBuilder.append(i);
        StringBuilder curStream = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            curStream.append(infiniteStream.next());
        }
        if (patternBuilder.toString().equals(curStream.toString()))
            return 0;
        int left = 0;
        while (left <= (int) 1e5) {
            left++;
            curStream.deleteCharAt(0);
            curStream.append(infiniteStream.next());
            if (patternBuilder.toString().equals(curStream.toString()))
                return left;
        }
        return -1;
    }
}