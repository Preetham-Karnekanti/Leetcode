class MagicDictionary {
    HashSet<String> hs;

    public MagicDictionary() {
        hs = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (String str : dictionary)
            hs.add(str);
    }

    public boolean search(String searchWord) {
        char chArray[] = searchWord.toCharArray();
        for (int i = 0; i < searchWord.length(); i++) {
            char original = chArray[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (chArray[i] != ch) {
                    chArray[i] = ch;
                    String str = new String(chArray);
                    if (hs.contains(str) && !str.equals(searchWord))
                        return true;
                }
            }
            chArray[i] = original;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */