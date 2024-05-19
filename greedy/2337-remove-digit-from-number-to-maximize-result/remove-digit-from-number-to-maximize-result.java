class Solution {
    public String removeDigit(String number, char digit) {
        String ans = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String temp = number.substring(0, i) + number.substring(i + 1);
                if (ans.compareTo(temp) < 0)
                    ans = temp;
            }
        }
        return ans;
    }
}