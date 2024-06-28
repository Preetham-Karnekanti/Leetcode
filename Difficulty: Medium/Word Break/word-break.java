//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        HashSet<String> words = new HashSet<>(dictionary);
        return helper(s, words, 0);
    }
    
    public static int helper(String s, HashSet<String> words, int idx){
        if(idx == s.length())
            return 1;
        for(int i = idx;i<s.length();i++){
            if(words.contains(s.substring(idx, i+1))){
                if(helper(s, words, i + 1) == 1)
                    return 1;
            }
        }
        return 0;
    }
}