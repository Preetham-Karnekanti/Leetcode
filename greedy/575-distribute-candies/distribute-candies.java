class Solution {
    public int distributeCandies(int[] candyType) {
        int required = candyType.length / 2;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : candyType)
            hs.add(i);
        return Math.min(hs.size(), required);
    }
}