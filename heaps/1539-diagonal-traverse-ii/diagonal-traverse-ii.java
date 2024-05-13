class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> {
            if (a.sum == b.sum)
                return b.row - a.row;
            return a.sum - b.sum;
        });
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                pq.add(new Triplet(sum, i, nums.get(i).get(j)));
            }
        }
        int arr[] = new int[pq.size()];
        int i = 0;
        while (pq.isEmpty() == false) {
            arr[i++] = pq.poll().value;
        }
        return arr;
    }
}

class Triplet {
    int sum;
    int row;
    int value;

    Triplet(int sum, int row, int value) {
        this.sum = sum;
        this.row = row;
        this.value = value;
    }
}