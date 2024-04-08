class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentsWith1 = 0;
        int studentsWith0 = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0)
                studentsWith0++;
            else
                studentsWith1++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && studentsWith0 == 0)
                return studentsWith1;
            else if (sandwich == 1 && studentsWith1 == 0)
                return studentsWith0;
            else if (sandwich == 0)
                studentsWith0--;
            else
                studentsWith1--;
        }
        return 0;
    }
}