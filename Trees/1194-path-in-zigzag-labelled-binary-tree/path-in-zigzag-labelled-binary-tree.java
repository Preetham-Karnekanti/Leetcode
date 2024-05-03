class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        int level = (int) (Math.log(label) / Math.log(2));
        result.add(label);
        while (level > 0) {
            label = ((1 << level) + ((1 << (level + 1)) - 1) - label) / 2;
            result.add(0, label);
            level--;
        }
        return result;
    }
}
