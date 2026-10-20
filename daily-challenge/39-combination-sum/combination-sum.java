// class Solution {
//     List<List<Integer>> answer;

//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         answer = new ArrayList<>();
//         helper(cadidates, target, 0, answer, new ArrayList<>());
//         return answer;
//     }

//     public void helper(int nums[], int target, int idx, List<List<Integer>> answer, List<Integer> temp) {
//         if (idx == nums.length) {
//             if (target == 0) {
//                 answer.add(new ArrayList<>(temp));
//             }
//             return;
//         }

//     }
// }

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, int idx, int target, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (idx == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[idx] <= target) {
            temp.add(nums[idx]);
            solve(nums, idx, target - nums[idx], ans, temp);
            temp.remove(temp.size() - 1);
        }
        solve(nums, idx + 1, target, ans, temp);
    }
}