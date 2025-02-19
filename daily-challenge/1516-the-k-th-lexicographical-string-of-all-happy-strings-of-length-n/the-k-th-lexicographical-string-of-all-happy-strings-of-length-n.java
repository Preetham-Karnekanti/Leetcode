class Solution {
    ArrayList<String> answer;

    public String getHappyString(int n, int k) {
        answer = new ArrayList<>();
        char arr[] = new char[] { 'a', 'b', 'c' };
        solve(arr, 'z', "", n);
        Collections.sort(answer);
        return answer.size() < k ? "" : answer.get(k - 1);
    }

    public void solve(char arr[], char prev, String temp, int n) {
        if (temp.length() == n) {
            answer.add(temp);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (prev == arr[i])
                continue;
            solve(arr, arr[i], temp + arr[i], n);
        }
    }
}