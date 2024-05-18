class Solution {
    public String maximumTime(String time) {
        char[] ch = time.toCharArray();
        if (ch[0] == '?') {
            if(ch[1] == '?')
                ch[0] = '2';
            else if (ch[1] >= '4')
                ch[0] = '1';
            else
                ch[0] = '2';
        }
        if (ch[1] == '?') {
            if (ch[0] == '1')
                ch[1] = '9';
            else if(ch[0] == '2')
                ch[1] = '3';
            else
                ch[1] = '9';
        }
        if (ch[3] == '?')
            ch[3] = '5';
        if (ch[4] == '?')
            ch[4] = '9';
        return new String(ch);
    }
}