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

        foreach(var key in charCount.Keys)
        {
            if(charCount[key] == 1)
            {
                return s.IndexOf(key);
            }
        }
        return -1;
        
    }
}