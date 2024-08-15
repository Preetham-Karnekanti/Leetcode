class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for (int i = 0; i < bills.length; i++) {
            int amt = bills[i];
            if (amt == 5)
                count5++;
            else if (amt == 10) {
                if (count5 == 0)
                    return false;
                count10++;
                count5--;
            } else {
                if (count10 >= 1 && count5 >= 1) {
                    count10--;
                    count5--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else
                    return false;
            }
        }
        return true;
    }
}