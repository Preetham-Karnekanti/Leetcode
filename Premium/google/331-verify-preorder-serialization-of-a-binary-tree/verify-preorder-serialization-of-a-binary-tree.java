class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        String nodes[] = preorder.split(",");
        for (String node : nodes) {
            slots--;
            if (slots < 0)
                return false;
            if (!node.equals("#"))
                slots += 2;
        }
        return slots == 0;
    }
}