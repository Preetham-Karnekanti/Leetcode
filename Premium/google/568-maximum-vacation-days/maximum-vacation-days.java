class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int maxWeeks = days[0].length;
        int totalCities = flights.length;
        int dp[][] = new int[maxWeeks + 1][totalCities + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return helper(flights, days, 0, 0, dp);
    }

    public int helper(int[][] flights, int[][] days, int currentCity, int curWeek, int[][] dp) {
        int maxWeeks = days[0].length;
        int totalCities = flights.length;
        if (curWeek == maxWeeks)
            return 0;
        if (dp[curWeek][currentCity] != -1)
            return dp[curWeek][currentCity];
        int stayInSameCity = days[currentCity][curWeek] + helper(flights, days, currentCity, curWeek + 1, dp);
        int goToOtherCity = 0;
        for (int i = 0; i < flights[currentCity].length; i++) {
            if (flights[currentCity][i] == 1) {
                goToOtherCity = Math.max(goToOtherCity, days[i][curWeek] + helper(flights, days, i, curWeek + 1, dp));
            }
        }
        return dp[curWeek][currentCity] = Math.max(goToOtherCity, stayInSameCity);
    }
}