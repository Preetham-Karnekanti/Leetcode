class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        if (str.indexOf("6") == -1)
            return num;
        int idx = str.indexOf('6');
        char ch[] = str.toCharArray();
        ch[idx] = '9';
        return Integer.parseInt(new String(ch));
    }
}