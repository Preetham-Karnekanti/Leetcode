//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
        if(a.length() + b.length() != c.length())
            return false;
        int dp[][] = new int[a.length()+ 1][b.length() + 1];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        return helper(a,b,c,0, 0, dp);
	}
	
	public boolean helper(String s1, String s2, String s3, int i, int j, int[][] dp) {
        if (i + j == s3.length())
            return true;
        if (dp[i][j] != -1)
            return dp[i][j] == 0 ? false : true;
        boolean one = false;
        boolean two = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
            one = helper(s1, s2, s3, i + 1, j, dp);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
            two = helper(s1, s2, s3, i, j + 1, dp);
        dp[i][j] = (two || one) == true ? 1 : 0;
        return two || one;
    }
}

