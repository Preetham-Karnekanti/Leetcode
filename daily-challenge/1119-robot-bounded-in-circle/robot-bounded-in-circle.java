class Solution {
    public boolean isRobotBounded(String instructions) {
        char dir = 'N';
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'G') {
                int directions[] = getDirections(dir);
                x += directions[0];
                y += directions[1];
            } else {
                dir = getNextDirection(instructions.charAt(i), dir);
            }
        }
        return (x == 0 && y == 0) || (dir != 'N');
    }

    public int[] getDirections(char dir) {
        switch (dir) {
            case 'N':
                return new int[] { 0, 1 };
            case 'E':
                return new int[] { 1, 0 };
            case 'W':
                return new int[] { -1, 0 };
            case 'S':
                return new int[] { 0, -1 };
        }
        return new int[] { -1, -1 };
    }

    public char getNextDirection(char turn, char dir) {
        if (turn == 'L') {
            switch (dir) {
                case 'N':
                    return 'W';
                case 'E':
                    return 'N';
                case 'W':
                    return 'S';
                case 'S':
                    return 'E';
            }
        } else {
            switch (dir) {
                case 'N':
                    return 'E';
                case 'E':
                    return 'S';
                case 'W':
                    return 'N';
                case 'S':
                    return 'W';
            }
        }
        return 'X';
    }
}