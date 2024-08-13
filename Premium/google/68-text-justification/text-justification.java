class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> wordsIntoLines = splitIntoSentnce(words, maxWidth);
        System.out.println(wordsIntoLines);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < wordsIntoLines.size() - 1; i++) {
            String justified = justifyTheSenctence(wordsIntoLines.get(i), maxWidth);
            res.add(justified);
        }
        int lastIdx = wordsIntoLines.size() - 1;
        String lastSentence = justifyLastSentence(wordsIntoLines.get(lastIdx), maxWidth);
        res.add(lastSentence);
        return res;
    }

    public List<String> splitIntoSentnce(String[] words, int maxWidth) {
        List<String> wordsIntoLines = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int width = maxWidth;
            String text = "";
            while (i < words.length && width > 0) {
                String word = words[i];
                if (word.length() <= width) {
                    text += word;
                    width -= word.length();
                } else
                    break;
                if (width > 0) {
                    text += " ";
                    width--;
                }
                i++;
            }
            wordsIntoLines.add(text);
        }
        return wordsIntoLines;
    }

    public String justifyTheSenctence(String sentence, int maxWidth) {
        sentence = sentence.strip();
        int extraspaces = maxWidth - sentence.length();
        int spacesToBeAdded[] = getSpacesToBeAddedBetweenEachWord(extraspaces, sentence.split(" ").length);
        String[] words = sentence.split(" ");
        int idx = 0;
        String justifiedString = words[0];
        if (words.length == 1) {
            for (int j = 0; j < spacesToBeAdded[0]; j++) {
                justifiedString += " ";
            }
        } else {
            for (int i = 1; i < words.length; i++) {
                for (int j = 0; j < spacesToBeAdded[i - 1]; j++) {
                    justifiedString += " ";
                }
                justifiedString += words[i];
            }
        }
        return justifiedString;
    }

    public int[] getSpacesToBeAddedBetweenEachWord(int extraSpaces, int totalWords) {
        if (totalWords == 1)
            return new int[] { extraSpaces };
        totalWords--;
        int spaces[] = new int[totalWords];
        Arrays.fill(spaces, 1);
        int idx = 0;
        while (extraSpaces > 0) {
            spaces[idx % totalWords]++;
            idx++;
            extraSpaces--;
        }
        return spaces;
    }

    public String justifyLastSentence(String word, int maxWidth) {
        if (word.length() == maxWidth)
            return word;
        int extra = maxWidth - word.length();
        while (extra-- > 0) {
            word += " ";
        }
        return word;
    }
}