//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] nums, int n, int k) {
        // code here
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            int target = k - nums[i];
            if(hm.containsKey(target))
                count += hm.get(target);
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
