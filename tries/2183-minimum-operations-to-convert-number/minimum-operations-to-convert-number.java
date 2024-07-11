class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        HashSet<Integer> vis = new HashSet<>();
        vis.add(start);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                int next = 0;
                for(int i = 0;i<nums.length;i++){
                    next = cur + nums[i];
                    if(next == goal)
                        return steps+1;
                    else if(!vis.contains(next) && next >=0 && next <= 1000){
                        q.add(next);
                        vis.add(next);
                    }
                    next = cur - nums[i];
                     if(next == goal)
                        return steps+1;
                    else if(!vis.contains(next) && next >=0 && next <= 1000){
                        q.add(next);
                        vis.add(next);
                    }
                    next = cur ^ nums[i];
                     if(next == goal)
                        return steps+1;
                    else if(!vis.contains(next) && next >=0 && next <= 1000){
                        q.add(next);
                        vis.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}