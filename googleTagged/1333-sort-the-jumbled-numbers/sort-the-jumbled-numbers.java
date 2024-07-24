class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair numWithIdx[] = new Pair[n];
        for (int i = 0; i < nums.length; i++) {
            numWithIdx[i] = new Pair(nums[i], i);
        }
        Arrays.sort(numWithIdx, (a, b) -> {
            int aNum = convertToMappings(a.value, mapping);
            int bNum = convertToMappings(b.value, mapping);
            return aNum == bNum ? a.idx - b.idx : aNum - bNum;
        });
        for (int i = 0; i < n; i++) {
            nums[i] = numWithIdx[i].value;
        }
        return nums;
    }

    public int convertToMappings(int num, int[] mappings) {
        if (num == 0)
            return mappings[0];
        StringBuilder res = new StringBuilder();
        int temp = num;
        while (num != 0) {
            res.append(mappings[num % 10]);
            num = num / 10;
        }
        res.reverse();
        return Integer.parseInt(res.toString());
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