class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> hs = new HashSet<>();
        for (int o[] : obstacles) {
            String key = o[0] + ":" + o[1];
            hs.add(key);
        }
        char curDirection = 'N';
        int x = 0;
        int y = 0;
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command < 0)
                curDirection = getNextDirection(curDirection, command);
            else {
                int[] nextCoordinates = getNextCoordinates(curDirection);
                int units = command;
                while (units-- > 0) {
                    int nextX = x + nextCoordinates[0];
                    int nextY = y + nextCoordinates[1];
                    String key = nextX + ":" + nextY;
                    if (hs.contains(key))
                        break;
                    x = nextX;
                    y = nextY;
                    max = Math.max(max, x * x + y * y);
                }
            }
        }
        return max;
    }

    public char getNextDirection(char direction, int command) {
        if (command == -1) {
            switch (direction) {
                case 'N':
                    return 'E';
                case 'E':
                    return 'S';
                case 'S':
                    return 'W';
                case 'W':
                    return 'N';
            }
        } else {
            switch (direction) {
                case 'N':
                    return 'W';
                case 'E':
                    return 'N';
                case 'S':
                    return 'E';
                case 'W':
                    return 'S';
            }
        }
        return 'K';
    }

    public int[] getNextCoordinates(char direction) {
        switch (direction) {
            case 'N':
                return new int[] { 0, 1 };
            case 'S':
                return new int[] { 0, -1 };
            case 'E':
                return new int[] { 1, 0 };
            case 'W':
                return new int[] { -1, 0 };
        }
        return new int[] { -1, -1 };
    }
}