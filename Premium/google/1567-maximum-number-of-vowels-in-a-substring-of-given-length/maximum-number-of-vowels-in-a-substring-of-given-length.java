class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int max = 0;
        int vowelCount = 0;
        for (int right = 0; right < s.length(); right++) {
            if (isVowel(s.charAt(right)))
                vowelCount++;
            while (right - left + 1 > k) {
                if (isVowel(s.charAt(left)))
                    vowelCount--;
                left++;
            }
            if(right - left + 1 == k)
                max = Math.max(max, vowelCount);
        }
        return max;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }
}