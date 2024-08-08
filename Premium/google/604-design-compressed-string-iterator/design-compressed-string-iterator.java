class StringIterator {

    int count;
    char currentChar;
    int idx;
    String str;

    public StringIterator(String compressedString) {
        count = 0;
        currentChar = compressedString.charAt(0);
        idx = 1;
        str = compressedString;
        while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
            count = count * 10 + str.charAt(idx) - '0';
            idx++;
        }
    }

    public char next() {
        if (count == 0) {
            if (idx >= str.length())
                return ' ';
            currentChar = str.charAt(idx);
            idx++;
            while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
                count = count * 10 + str.charAt(idx) - '0';
                idx++;
            }
        }
        count--;
        return currentChar;
    }

    public boolean hasNext() {
        return count > 0 || idx < str.length();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */