class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length())
            return false;
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            Character wc = word.charAt(i);
            Character ac = abbr.charAt(j);
            if (Character.isLetter(ac) && wc != ac)
                return false;
            else {
                if (Character.isDigit(ac)) {
                    int a = ac - '0';
                    if (a == 0)
                        return false;
                    while (j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))) {
                        a = a * 10 + abbr.charAt(j + 1) - '0';
                        j++;
                    }
                    i += a - 1;
                }
            }
            j++;
            i++;
        }
        return i == word.length() && j == abbr.length();
    }
}