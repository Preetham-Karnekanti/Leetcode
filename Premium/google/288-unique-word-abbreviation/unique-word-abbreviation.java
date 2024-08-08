class ValidWordAbbr {
    HashMap<String, HashSet<String>> hm;

    public ValidWordAbbr(String[] dictionary) {
        hm = new HashMap<>();
        for (String str : dictionary) {
            String abbrevation = abbrevate(str);
            hm.putIfAbsent(abbrevation, new HashSet<>());
            hm.get(abbrevation).add(str);
        }
        System.out.println(hm);
    }

    public boolean isUnique(String word) {
        String abbrevation = abbrevate(word);
        if (!hm.containsKey(abbrevation))
            return true;
        if (hm.get(abbrevation).size() > 1)
            return false;
        if(hm.get(abbrevation).size() == 1 && hm.get(abbrevation).contains(word))
            return true;
        return false;
    }

    public String abbrevate(String str) {
        if (str.length() < 2)
            return str;
        return str.charAt(0) + "" + (str.length() - 2) + "" + str.charAt(str.length() - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */