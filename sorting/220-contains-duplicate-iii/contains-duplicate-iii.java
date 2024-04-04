public class Solution {
    // Get the ID of the bucket from element value num and bucket width
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getBucketId(long num, long width) {
        return (num < 0) ? (num + 1) / width - 1 : num / width;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0 || indexDiff < 0 || nums.length < 2) return false;
        Map<Long, Long> bucket = new HashMap<>();
        long width = (long)valueDiff + 1;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            long bucketId = getBucketId(num, width);
            // check if bucket bucketId is empty, each bucket may contain at most one element
            if (bucket.containsKey(bucketId))
                return true;
            // check the neighbor buckets for almost duplicate
            if (bucket.containsKey(bucketId - 1) && Math.abs(num - bucket.get(bucketId - 1)) < width)
                return true;
            if (bucket.containsKey(bucketId + 1) && Math.abs(num - bucket.get(bucketId + 1)) < width)
                return true;
            // now bucket bucketId is empty and no almost duplicate in neighbor buckets
            bucket.put(bucketId, (long)num);
            if (i >= indexDiff) bucket.remove(getBucketId(nums[i - indexDiff], width));
        }
        return false;
    }
}