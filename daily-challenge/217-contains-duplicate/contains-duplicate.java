class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>((int)1e5);
        for (int i : nums) {
            if (hs.contains(i))
                return true;
            hs.add(i);
        }
        return false;
    }
}