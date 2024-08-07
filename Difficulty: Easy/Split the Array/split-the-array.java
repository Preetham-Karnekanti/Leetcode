//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    
    public static int countgroup(int a[], int n) 
    { 
        // Complete the function
        int xor = 0;
        for(int i : a){
            xor ^= i;
        }
        if(xor != 0)
            return 0;
        int i = 0;
        int ans = 1;
        int m = (int)1e9 + 7;
        while(i < n - 1){
            ans = (ans * 2)%m;
            i++;
        }
        return ans - 1;
    }
    
}



//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.countgroup(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


            


// } Driver Code Ends