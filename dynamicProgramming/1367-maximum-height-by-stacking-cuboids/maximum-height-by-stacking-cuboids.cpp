class Solution {
public:
    int maxHeight(vector<vector<int>>& input) {
        for (auto& x : input) {
            sort(begin(x), end(x));
        }
        input.push_back({0, 0, 0});
        sort(begin(input), end(input));

        int n = input.size();
        int result = 0;
        vector<int> dp(n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (input[j][0] <= input[i][0] && input[j][1] <= input[i][1] &&
                    input[j][2] <= input[i][2]) {
                    dp[i] = max(dp[i], dp[j] + input[i][2]);
                    result = max(result, dp[i]);
                }
            }
        }
        return result;
    }
};