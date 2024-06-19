//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        int max = -1;
        for(int right = 0;right<s.length();right++){
            hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);
            while(hm.size() > k){
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                if(hm.get(s.charAt(left)) == 0)
                    hm.remove(s.charAt(left));
                left++;
            }
            if(hm.size() == k){
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}