class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : hand)
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        for (int i = 0; i < hand.length; i++) {
            if (hm.get(hand[i]) == 0)
                continue;
            int start = hand[i];
            for (int j = start; j < start + groupSize; j++) {
                if (hm.get(j) == null || hm.get(j) <= 0)
                    return false;
                hm.put(j, hm.get(j) - 1);
            }
        }
        return true;
    }
}