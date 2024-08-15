class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        for (String s : sentence) {
            if (s.length() > cols)
                return 0;
        }
        int answer = 0;
        int curRow = 0;
        int index = 0;
        while (curRow < rows) {
            int curWidth = cols;
            while (curWidth > 0) {
                if (curWidth < sentence[index].length())
                    break;
                curWidth = curWidth - sentence[index++].length() - 1;
                if (index == sentence.length) {
                    answer++;
                    index = 0;
                }
            }
            curRow++;
        }
        return answer;
    }
}