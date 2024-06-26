//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int k) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j< n;j++){
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int l = j + 1;
                int m = n - 1;
                while(l < m){
                    int sum = nums[i] + nums[j] + nums[l] + nums[m];
                    if(sum == k){
                        al.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[m])));
                        l++;
                        m--;
                        while(l < m && nums[m] == nums[m + 1])
                            m--;
                    }else if(sum > k){
                        m--;
                    }else
                        l++;
                }
            }
        }
        return al;
    }
}