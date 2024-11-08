//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	    int sum = 0;
	    for(int i: a){
	        sum += i;
	    }
	    if(sum % k !=0 || k > n)
	        return false;
	    return helper(a, k,0, sum/k, 0);
    }
    
    public boolean helper(int arr[],int k, int idx, int target, int sum){
        if(k == 0)
            return true;
         if(sum == target)
            return helper(arr, k - 1, 0, target, 0);
        if(idx >= arr.length)
            return false;
        
       
        if(arr[idx] != -1 && arr[idx] + sum <= target){
            int val = arr[idx];
            arr[idx] = -1;
            if(helper(arr, k, idx + 1, target, sum + val))
                return true;
            arr[idx] = val;
        }
        return helper(arr, k, idx + 1, target, sum);
    }
}
