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
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        Trie root = new Trie();
        for(int i = 0;i<N;i++){
            insert(arr[i], root);
        }
        String ans[] = new String[N];
        for(int i = 0;i<N;i++){
            ans[i] = search(arr[i], root);
        }
        return ans;
    }
    public static void insert(String word, Trie root){
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(root.arr[idx] == null)
                root.arr[idx] = new Trie();
            root = root.arr[idx];
            root.count++;
        }
    }
    
    public static String search(String word, Trie root){
        String ans = "";
        for(int i = 0;i<word.length();i++){
            int idx = word.charAt(i)- 'a';
            ans += word.charAt(i);
            root = root.arr[idx];
            if(root.count == 1)
                return ans;
        }
        return word;
    }
};

class Trie{
    Trie arr[];
    int count;
    Trie(){
        arr = new Trie[26];
        count = 0;
    }
}