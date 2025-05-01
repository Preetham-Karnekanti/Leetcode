class SnakeGame {

    int height;
    int width;
    Deque<Pair<Integer, Integer>> snake;
    HashSet<Pair<Integer, Integer>> cellsOccupied;
    int food[][];
    int foodIdx;

    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        this.foodIdx = 0;
        snake = new LinkedList<>();
        cellsOccupied = new HashSet<>();
        snake.add(new Pair<>(0, 0));
        cellsOccupied.add(new Pair<>(0, 0));
    }

    public int move(String direction) {
        Pair<Integer, Integer> head = snake.peek();
        int newHeadRow = head.getKey();
        int newHeadCol = head.getValue();
        switch (direction) {
            case "U":
                newHeadRow--;
                break;
            case "D":
                newHeadRow++;
                break;
            case "L":
                newHeadCol--;
                break;
            case "R":
                newHeadCol++;
                break;
        }
        if (isCrossing(newHeadRow, newHeadCol))
            return -1;
        Pair<Integer, Integer> tail = snake.peekLast();
        Pair<Integer, Integer> newHead = new Pair<>(newHeadRow, newHeadCol);
        boolean isBitingItSelf = cellsOccupied.contains(newHead)
                && !(newHead.getKey() == tail.getKey() && newHead.getValue() == tail.getValue());
        if (isBitingItSelf)
            return -1;
        if (foodIdx < food.length && food[foodIdx][0] == newHead.getKey() && food[foodIdx][1] == newHead.getValue()) {
            foodIdx++;
        } else {
            snake.pollLast();
            cellsOccupied.remove(tail);
        }
        snake.addFirst(newHead);
        cellsOccupied.add(newHead);
        return this.snake.size() - 1;
    }

    public boolean isCrossing(int r, int c) {
        if (r < 0 || c < 0 || r >= height || c >= width)
            return true;
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */