public class Solution {
    public int FirstUniqChar(string s) {
        Dictionary<char, int> charCount = new Dictionary<char, int>();
        foreach(char c in s)
        {
            if(!charCount.ContainsKey(c))
            {
                charCount.Add(c, 1);
            }
            else
            {
                charCount[c]++;
            }
        }

        for(int i = 0; i< s.Length; i++)
        {
            if(charCount[s[i]] == 1)
            {
                return i;
            }
        }
        return -1;
        
    }
}