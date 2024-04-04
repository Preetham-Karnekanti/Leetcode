class Pair {
    int index, ele;

    Pair(int a, int b) {
        this.index = a;
        this.ele = b;
    }
}

class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int res[] = new int[n];
        Arrays.sort(nums1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a1, b1) -> {
            return b1.ele - a1.ele;
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(i, nums2[i]));
        }
        int left = 0, right = n - 1;
        while (!pq.isEmpty()) {
            if (pq.peek().ele < nums1[right]) {
                res[pq.poll().index] = nums1[right];
                right--;
            } else {
                res[pq.poll().index] = nums1[left];
                left++;
            }
        }
        return res;
    }
}