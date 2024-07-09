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
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        int lpsArr[] = new int[s.length()];
        int i = 1;
        int len = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lpsArr[i] = len + 1;
                len++;
                i++;
            }else{
                if(len != 0)
                    len = lpsArr[len-1];
                else{
                    lpsArr[i] = 0;
                    i = i + 1;
                }
            }
        }
        return lpsArr[s.length()-1];
    }
}