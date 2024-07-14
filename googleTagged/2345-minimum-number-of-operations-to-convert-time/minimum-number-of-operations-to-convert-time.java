class Solution {
    public int convertTime(String current, String correct) {
        String currentTime[] = current.split(":");
        String correctTime[] = correct.split(":");
        int correctHours = Integer.parseInt(correctTime[0]);
        int currentHours = Integer.parseInt(currentTime[0]);
        int correctMin = Integer.parseInt(correctTime[1]);
        int currentMin = Integer.parseInt(currentTime[1]);
        int diffHours = correctHours - currentHours;
        int diffMin = correctMin - currentMin;
        if (diffHours < 0)
            diffHours = 24 + diffHours;
        if (diffMin < 0) {
            diffMin = 60 + diffMin;
            diffHours--;
        }
        int totalMin = diffHours * 60 + diffMin;
        int ans = 0;
        if (totalMin / 60 != 0) {
            ans += totalMin / 60;
            totalMin %= 60;
        }
        if (totalMin / 15 != 0) {
            ans += totalMin / 15;
            totalMin %= 15;
        }
        if (totalMin / 5 != 0) {
            ans += totalMin / 5;
            totalMin %= 5;
        }
        if (totalMin / 1 != 0) {
            ans += totalMin / 1;
            totalMin %= 1;
        }


        return ans;
    }
}