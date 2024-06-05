class Solution {
    public List<String> commonChars(String[] words) {
        int freq[] = new int[26];
        for (int i = 0; i < words[0].length(); i++)
            freq[words[0].charAt(i) - 'a']++;
        for (int i = 1; i < words.length; i++) {
            int temp[] = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                if (freq[k] > 0 && temp[k] > 0) {
                    freq[k] = Math.min(freq[k], temp[k]);
                } else
                    freq[k] = 0;
            }
        }
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                String s = "" + (char) (i + 'a');
                al.add(s);
            }
        }
        return al;
    }
}