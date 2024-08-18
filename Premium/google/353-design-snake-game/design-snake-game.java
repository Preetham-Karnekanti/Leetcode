class SnakeGame {

    int height;
    int width;
    HashSet<Pair<Integer, Integer>> cellsOccupiedBySnake;
    Deque<Pair<Integer, Integer>> snake;
    int[][] food;
    int foodIndex;

    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        cellsOccupiedBySnake = new HashSet<>();
        cellsOccupiedBySnake.add(new Pair<Integer, Integer>(0, 0));
        snake = new LinkedList<>();
        snake.add(new Pair<Integer, Integer>(0, 0));
    }

    public int move(String direction) {
        Pair<Integer, Integer> headCell = snake.peek();
        int newHeadRow = headCell.getKey();
        int newHeadCol = headCell.getValue();
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
        if (isCrossingBoudary(newHeadRow, newHeadCol)) {
            return -1;
        }
        Pair<Integer, Integer> currentTail = snake.peekLast();
        Pair<Integer, Integer> newHead = new Pair<>(newHeadRow, newHeadCol);
        boolean isBitingSelf = this.cellsOccupiedBySnake.contains(newHead)
                && !(newHead.getKey() == currentTail.getKey() && newHead.getValue() == currentTail.getValue());
        if (isBitingSelf)
            return -1;
        if (foodIndex < food.length && (food[foodIndex][0] == newHeadRow && food[foodIndex][1] == newHeadCol)) {
            foodIndex++;
        } else {
            snake.pollLast();
            this.cellsOccupiedBySnake.remove(currentTail);
        }
        snake.addFirst(newHead);
        cellsOccupiedBySnake.add(newHead);
        return this.snake.size() - 1;
    }

    public boolean isCrossingBoudary(int r, int c) {
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