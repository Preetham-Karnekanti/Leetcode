public class Solution {
    public int MaxCount(int[] banned, int n, int maxSum) {

        int count=0, sum=0;
        for(int i=1; i<= n; i++)
        {
            if(Array.IndexOf(banned, i) ==  -1)
            {
                
                sum += i;
                if(sum <= maxSum)
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}