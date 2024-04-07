class Solution {
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char[] ch = str.toCharArray();
        int size = ch.length;
        int i = 0;
        for (i = size - 2; i >= 0; i--) {
            if (ch[i] < ch[i + 1])
                break;
        }
        if (i < 0)
            return -1;
        int j = 0;
        for (j = size - 1; j > i; j--) {
            if (ch[j] > ch[i])
                break;
        }
        swap(ch, i, j);
        reverse(ch, i + 1, size - 1);
        long num = 0;
        for (i = 0; i < ch.length; i++) {
            num = num * 10 + ch[i] - '0';
        }
        return num > Integer.MAX_VALUE ? -1 : (int) num;
    }

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public void reverse(char ch[], int i, int j) {
        while (i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
}