class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i[] : lights) {
            int pos = i[0];
            int range = i[1];
            int left = pos - range;
            int right = pos + range;
            map.put(left, map.getOrDefault(left, 0) + 1);
            map.put(right + 1, map.getOrDefault(right + 1, 0) - 1);
        }
        int max = 0;
        int idx = 0;
        int sum = 0;
        for(int key: map.keySet()){
            sum += map.get(key);
            if(sum > max){
                idx = key;
                max = sum;
            }
        }
        return idx;
    }
}