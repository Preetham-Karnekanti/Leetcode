class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> al = new ArrayList<>();
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            hs.put(words[i], i);

        if (hs.containsKey("")) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(""))
                    continue;
                if (isPallindrome(words[i])) {
                    al.add(Arrays.asList(i, hs.get("")));
                    al.add(Arrays.asList(hs.get(""), i));
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            if (hs.containsKey(word) && hs.get(word) != i)
                al.add(Arrays.asList(i, hs.get(word)));
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPallindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();
                    if (hs.containsKey(rev) && hs.get(rev) != i)
                        al.add(Arrays.asList(hs.get(rev), i));
                }
                if(isPallindrome(right)){
                       String rev = new StringBuilder(left).reverse().toString();
                       if(hs.containsKey(rev) && hs.get(rev) !=i)
                        al.add(Arrays.asList(i, hs.get(rev)));
                }
            }
        }

        return al;
    }

    public boolean isPallindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}