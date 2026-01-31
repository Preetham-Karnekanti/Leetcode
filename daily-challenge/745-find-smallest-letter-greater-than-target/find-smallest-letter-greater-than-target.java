class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = '#';
        for (char i : letters) {
            if (i > target) {
                ans = i;
                break;
            }
        }
        return ans == '#' ? letters[0] : ans;
    }
}