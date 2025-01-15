import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitsInNum2 = countBits(num2);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                if (bitsInNum2 > 0) {
                    result |= (1 << i);
                    bitsInNum2--;
                }
            }
        }

        for (int i = 0; i < 32 && bitsInNum2 > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i);
                bitsInNum2--;
            }
        }

        return result;
    }

    public int countBits(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
