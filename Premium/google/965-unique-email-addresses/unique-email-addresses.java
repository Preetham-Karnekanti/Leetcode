class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> unique = new HashSet<>();
        for (String mail : emails) {
            String parsed = parseMail(mail);

            unique.add(parsed);
        }
        return unique.size();
    }

    public String parseMail(String mail) {
        int indexOfAt = mail.indexOf('@');
        String localName = mail.substring(0, indexOfAt);
        String requiredMail = removeExcess(localName);
        String localNameWithoutSpecialCharacters = "";
        for (int i = 0; i < requiredMail.length(); i++) {
            if (requiredMail.charAt(i) == '.')
                continue;
            localNameWithoutSpecialCharacters += requiredMail.charAt(i);
        }
        return localNameWithoutSpecialCharacters + mail.substring(indexOfAt);
    }

    public String removeExcess(String localName) {
        int indexOfPlus = localName.indexOf('+');
        if (indexOfPlus == -1)
            return localName;
        return localName.substring(0, indexOfPlus);
    }
}