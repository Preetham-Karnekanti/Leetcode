public class Solution {
    public int MaxCount(int[] banned, int n, int maxSum) {
HashSet<int> b = new HashSet<int>();

foreach(int a in banned)
{
    b.Add(a);
}
        int count=0, sum=0;
        for(int i=1; i<= n; i++)
        {
            if(!b.Contains(i))
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