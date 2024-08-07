class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair numWithIdx[] = new Pair[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numWithIdx[i] = new Pair(nums[i], i);
        }
        Arrays.sort(numWithIdx, (a, b) -> {
            int aNum = getMapping(a.value, mapping, hm);
            int bNum = getMapping(b.value, mapping, hm);
            return aNum == bNum ? a.idx - b.idx : aNum - bNum;
        });
        for (int i = 0; i < n; i++) {
            nums[i] = numWithIdx[i].value;
        }
        return nums;
    }

    public int getMapping(int num, int mappings[], HashMap<Integer, Integer> hm) {
        if (hm.containsKey(num))
            return hm.get(num);
        int mappedNumber = convertToMappings(num, mappings);
        hm.put(num, mappedNumber);
        return mappedNumber;
    }

    public int convertToMappings(int num, int[] mappings) {
        if (num == 0)
            return mappings[0];
        int placeValue = 1;
        int res = 0;
        while (num != 0) {
            res = placeValue * mappings[num % 10] + res;
            num = num / 10;
            placeValue *= 10;
        }
        return res;
    }
}

class Pair {
    int value;
    int idx;

    Pair(int v, int i) {
        value = v;
        idx = i;
    }
}