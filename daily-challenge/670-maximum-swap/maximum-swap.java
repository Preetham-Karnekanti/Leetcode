class Solution {
    public int maximumSwap(int num) {
        int max = num;
        char[] ch = String.valueOf(num).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                swap(ch, i, j);
                int number = Integer.parseInt(new String(ch));
                max = Math.max(max, number);
                swap(ch, i, j);
            }
        }
        return max;
    }

    public void swap(char ch[], int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}