class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8)
            return new ArrayList<>();
        int min[] = new int[60];
        int hours[] = new int[12];
        List<String> al = new ArrayList<>();
        for (int i = 0; i < min.length; i++) {
            min[i] = countSetBits(i);
        }
        for (int i = 0; i < hours.length; i++)
            hours[i] = countSetBits(i);
        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < min.length; j++) {
                if (hours[i] + min[j] == turnedOn) {
                    al.add(formatTime(i, j));
                }
            }
        }
        return al;
    }

    public String formatTime(int hour, int min) {
        String ans = hour + ":";
        if (min < 10)
            ans = ans + "0";
        ans = ans + min;
        return ans;
    }

    public int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            count = count + ((n >> i) & 1);
        }
        return count;
    }
}