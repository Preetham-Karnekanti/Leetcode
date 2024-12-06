public class Solution {
    public int MaxCount(int[] banned, int n, int maxSum) {
// HashSet<int> b = new HashSet<int>();
bool[] b = new bool[10001];
foreach(int a in banned)
{
    b[a] = true;
}
        int count=0, sum=0;
        for(int i=1; i<= n; i++)
        {
            if(!b[i])
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