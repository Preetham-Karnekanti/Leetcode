class NumberContainers {
    HashMap<Integer, Integer> indicesToNumber;
    HashMap<Integer, PriorityQueue<Integer>> smallestIndex;

    public NumberContainers() {
        indicesToNumber = new HashMap<>();
        smallestIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indicesToNumber.containsKey(index) == false) {
            indicesToNumber.put(index, number);
            smallestIndex.putIfAbsent(number, new PriorityQueue<>((a, b) -> Integer.compare(a, b)));
            smallestIndex.get(number).add(index);
        } else {
            int prevNumber = indicesToNumber.get(index);
            if (prevNumber != number) {
                smallestIndex.get(prevNumber).remove(index);
                indicesToNumber.put(index, number);
                smallestIndex.putIfAbsent(number, new PriorityQueue<>((a, b) -> Integer.compare(a, b)));
                smallestIndex.get(number).add(index);
            }
        }
    }

    public int find(int number) {
        if (smallestIndex.get(number) == null || smallestIndex.get(number).size() == 0)
            return -1;
        return smallestIndex.get(number).peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */