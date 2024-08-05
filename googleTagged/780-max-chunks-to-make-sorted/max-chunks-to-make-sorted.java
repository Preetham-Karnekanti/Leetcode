class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            hs.add(arr[i]);
            if(hasAll(hs, i))
                count++;
        }
        return count;
    }
    public boolean hasAll(HashSet<Integer> hs, int i){
        for(int k = 0;k<=i;k++){
            if(!hs.contains(k))
                return false;
        }
        return true;
    }
}