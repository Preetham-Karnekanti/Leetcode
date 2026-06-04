class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int k = num1;k<=num2;k++){
            String str = String.valueOf(k);
            for(int i = 1;i<str.length()-1;i++){
                if(str.charAt(i-1) < str.charAt(i) && str.charAt(i) > str.charAt(i + 1))    
                    count++;
                else if(str.charAt(i - 1) > str.charAt(i) && str.charAt(i) < str.charAt(i + 1))
                    count++;
            }
        }
        return count;
    }
}