class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        Arrays.sort(ch);
        int pow = 1;
        for (int i = 0; i < 31; i++) {
            if (hasSameDigits(ch, pow))
                return true;
            pow *= 2;
        }
        return false;
    }

    public boolean hasSameDigits(char[] ch, int num) {
        char[] ch1 = String.valueOf(num).toCharArray();
        Arrays.sort(ch1);
        return Arrays.equals(ch1, ch);
    }
}