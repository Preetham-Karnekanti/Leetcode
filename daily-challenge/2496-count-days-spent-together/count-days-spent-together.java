class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrival = calculateNofdaysPassed(arriveAlice);
        int aliceDeparture = calculateNofdaysPassed(leaveAlice);
        int bobArrival = calculateNofdaysPassed(arriveBob);
        int bobDeparture = calculateNofdaysPassed(leaveBob);

        int count = 0;
        int start = Math.max(aliceArrival, bobArrival);
        int end = Math.min(aliceDeparture, bobDeparture);

        return Math.max(0, end - start + 1);
    }

    public int calculateNofdaysPassed(String date) {
        int daysInMonth[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String dateArr[] = date.split("-");
        int month = Integer.parseInt(dateArr[0]);
        int day = Integer.parseInt(dateArr[1]);
        int daysPassed = day;
        for (int i = 0; i < month - 1; i++) {
            daysPassed += daysInMonth[i];
        }
        return daysPassed;
    }
}