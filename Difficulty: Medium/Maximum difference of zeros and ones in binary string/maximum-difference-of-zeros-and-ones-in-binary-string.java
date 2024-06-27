//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String s) {
        // code here
        int sum = 0;
        int max = 0;
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '0')
                sum +=1;
            else{
                cnt++;
                sum--;
            }
            sum = Math.max(sum, 0);
            max = Math.max(max, sum);
        }
        if(cnt == s.length())
            return -1;
        return max;
    }
}