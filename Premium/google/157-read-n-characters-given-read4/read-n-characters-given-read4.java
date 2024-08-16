/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */

    public int read(char[] buf, int n) {
        int count = 0;
        int chars = 4;
        char buf4[] = new char[4];
        while (count < n && chars == 4) {
            chars = read4(buf4);
            for (int i = 0; i < chars; i++) {
                if (count == n)
                    return count;
                buf[count] = buf4[i];
                count++;
            }
        }
        return count;
    }
}