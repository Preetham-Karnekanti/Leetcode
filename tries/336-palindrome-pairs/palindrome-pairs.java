class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], i);
        }
        if (hm.containsKey("")) {
            int idx = hm.get("");
            for (int i = 0; i < words.length; i++) {
                if (idx == i)
                    continue;
                if (isPallindrome(words[i])) {
                    res.add(new ArrayList<>(Arrays.asList(idx, i)));
                    res.add(new ArrayList<>(Arrays.asList(i, idx)));
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (hm.containsKey(reverse) && hm.get(reverse) != i) {
                res.add(new ArrayList<>(Arrays.asList(i, hm.get(reverse))));
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPallindrome(left)) {
                    String reverse = new StringBuilder(right).reverse().toString();
                    if (hm.containsKey(reverse) && hm.get(reverse) != i) {
                        res.add(new ArrayList<>(Arrays.asList(hm.get(reverse), i)));
                    }
                }
                if (isPallindrome(right)) {
                    String reverse = new StringBuilder(left).reverse().toString();
                    if (hm.containsKey(reverse) && hm.get(reverse) != i) {
                        res.add(new ArrayList<>(Arrays.asList(i, hm.get(reverse))));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPallindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}