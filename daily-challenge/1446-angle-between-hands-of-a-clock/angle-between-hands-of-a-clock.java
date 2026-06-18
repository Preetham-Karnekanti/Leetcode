class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12)
            hour = 0;
        double degreesOfMin = 6 * minutes;
        double degreesOfHr = hour * 30 + 0.5 * minutes;
        double diff = Math.abs(degreesOfMin - degreesOfHr);

        return Math.min(diff, 360.0 - diff);
    }
}