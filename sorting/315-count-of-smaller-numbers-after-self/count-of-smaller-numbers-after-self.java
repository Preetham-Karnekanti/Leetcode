class Solution {
    ArrayList<Integer> ans;

    public List<Integer> countSmaller(int[] nums) {
        ans = new ArrayList<>();
        Pair[] temp = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++)
            temp[i] = new Pair(nums[i], i);
        int result[] = new int[nums.length];
        mergesort(temp, 0, nums.length - 1, result);
        for (int i : result)
            ans.add(i);
        return ans;
    }

    public void mergesort(Pair nums[], int low, int high, int[] result) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        mergesort(nums, low, mid, result);
        mergesort(nums, mid + 1, high, result);
        merge(nums, low, mid, high, result);
    }

    public void merge(Pair nums[], int low, int mid, int high, int result[]) {
        int i = low;
        int j = mid + 1;
        int count = 0;
        ArrayList<Pair> al = new ArrayList<>();
        while (i <= mid && j <= high) {
            if (nums[i].value <= nums[j].value) {
                result[nums[i].index] += count;
                al.add(nums[i]);
                i++;
            } else {
                count++;
                al.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            result[nums[i].index] += count;
            al.add(nums[i++]);
        }
        while (j <= high) {
            al.add(nums[j++]);
        }
        for (i = 0; i < al.size(); i++)
            nums[i + low] = al.get(i);
    }
}

class Pair {
    int value;
    int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}