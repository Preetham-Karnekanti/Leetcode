public class Solution {

    public int minimizeXor(int num1, int num2) {
        int result = 0;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;
        int currentBit = 31; 
        while (setBitsCount < targetSetBitsCount) {
            if (
                isSet(num1, currentBit) ||
                (targetSetBitsCount - setBitsCount > currentBit)
            ) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit--;
        }

        return result;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }
}