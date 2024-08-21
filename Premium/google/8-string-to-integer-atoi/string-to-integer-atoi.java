class Solution {
    public int myAtoi(String s) {
        s = s.strip();
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) - '0' < 0 && s.charAt(0) - '0' > 9)
            return 0;
        boolean isNegative = s.charAt(0) == '-' ? true : false;
        int i = isNegative || s.charAt(0) == '+' ? 1 : 0;
        long number = 0;
        int flag = 0;
        for (; i < s.length(); i++) {
            if (flag == 1)
                return isNegative ? (int) -number : (int) number;

            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                int num = s.charAt(i) - '0';
                number = number * 10 + num;
                if (number > Integer.MAX_VALUE)
                    return !isNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            } else {
                flag = 1;
            }
        }
        if (isNegative && -number <= Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (number > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return isNegative ? (int) -number : (int) number;

    }
}