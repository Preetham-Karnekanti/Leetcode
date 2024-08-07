class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('1', '1');
        hm.put('6', '9');
        hm.put('0', '0');
        hm.put('8', '8');
        hm.put('9', '6');
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (hm.get(num.charAt(i)) == null || hm.get(num.charAt(j)) == null)
                return false;
            if (hm.get(num.charAt(i)) != num.charAt(j))
                return false;
            if (hm.get(num.charAt(j)) != num.charAt(i))
                return false;
            i++;
            j--;
        }
        return true;
    }
}