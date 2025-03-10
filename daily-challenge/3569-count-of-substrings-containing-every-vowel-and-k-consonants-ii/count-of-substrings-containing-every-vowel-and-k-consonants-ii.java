class Solution {
    public long countOfSubstrings(String s, int k) {
        return helper(s, k) - helper(s, k + 1);
    }

    public long helper(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int n = s.length();
        long count = 0;
        int left = 0;
        int consonantCount = 0;
        Map<Character, Integer> vowelCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            if (vowels.contains(ch)) {
                vowelCount.put(ch, vowelCount.getOrDefault(ch, 0) + 1);
            } else if (Character.isLetter(ch)) {
                consonantCount++;
            }

            while (vowelCount.size() == 5 && consonantCount >= k) {
                count += n - right;
                char leftChar = s.charAt(left);
                if (vowels.contains(leftChar)) {
                    vowelCount.put(leftChar, vowelCount.get(leftChar) - 1);
                    if (vowelCount.get(leftChar) == 0) {
                        vowelCount.remove(leftChar);
                    }
                } else if (Character.isLetter(leftChar)) {
                    consonantCount--;
                }
                left++;
            }
        }

        return count;
    }
}