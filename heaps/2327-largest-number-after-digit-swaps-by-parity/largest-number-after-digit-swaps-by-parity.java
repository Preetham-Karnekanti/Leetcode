class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        int temp = num;
        while (temp != 0) {
            int rem = temp % 10;
            if (rem % 2 == 0)
                even.add(rem);
            else
                odd.add(rem);
            temp = temp / 10;
        }
        char ch[] = String.valueOf(num).toCharArray();
        String str = "";
        for (int i = 0; i < ch.length; i++) {
            if (Character.getNumericValue(ch[i]) % 2 == 0) {
                str += "" + even.poll();
            } else {
                str += "" + odd.poll();
            }
        }
        return Integer.parseInt(str);
    }
}