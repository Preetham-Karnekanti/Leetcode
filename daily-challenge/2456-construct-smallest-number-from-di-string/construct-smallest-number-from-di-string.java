class Solution {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();

        for (int index = 0; index <= pattern.length(); index++) {
            numStack.push(index + 1);

            if (index < pattern.length() && pattern.charAt(index) == 'I') {
                while (!numStack.isEmpty()) {
                    result.append(numStack.pop());
                }
            }
        }

        while(!numStack.isEmpty())
              result.append(numStack.pop());

        return result.toString();
    }
}