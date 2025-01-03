class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        halfSum = sum(nums) / 2
        curr, ans = 0, 0
        for n in nums[:-1]:
            curr += n
            ans += curr >= halfSum
        return ans