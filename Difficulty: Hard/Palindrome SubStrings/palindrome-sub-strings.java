class Solution {
    public int countPS(String s) {
        // code here
        int count = 0;
        int n = s.length();
        for(int i = 0;i<s.length();i++){
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 >=2){
                    count++;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 >=2){
                    count++;
                }
                left--;
                right++;
            }
        }
        return count;
    }
}