class Solution {
    public String reorderSpaces(String text) {
        int originalLength = text.length();
        int spaceCount = 0;
        int wordCount = 0;
        ArrayList<String> words = getWords(text);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                spaceCount++;
        }
        int totalWords = words.size();
        if (totalWords == 1) {
            String answer = words.get(0);
            for (int j = 0; j < spaceCount; j++) {
                answer += ' ';
            }
            return answer;
        }
        int spaceBetweenEachWord = spaceCount / (totalWords - 1);
        int excessSpaces = spaceCount % (totalWords - 1);
        String answer = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            for (int j = 0; j < spaceBetweenEachWord; j++) {
                answer += ' ';
            }
            answer += words.get(i);
        }
        for (int j = 0; j < excessSpaces; j++) {
            answer += ' ';
        }
        return answer;
    }

    public ArrayList<String> getWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                i++;
                continue;
            }
            String temp = "";
            while (i < text.length() && text.charAt(i) != ' ') {
                temp += text.charAt(i++);
            }
            words.add(temp);
        }
        return words;
    }
}