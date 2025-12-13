class Solution {
    public int[] sortByReflection(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            int x = reflection(a);
            int y = reflection(b);
            return x == y ? Integer.compare(a, b) : Integer.compare(x, y);
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    public int reflection(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}