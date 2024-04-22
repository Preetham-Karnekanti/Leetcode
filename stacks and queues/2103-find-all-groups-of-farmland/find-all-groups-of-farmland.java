class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    dfs(land, i, j, al);
                }
            }
        }
        if(al.size() == 0){
            return new int[0][0];
        }
        int arr[][] = new int[al.size()][4];
        for(int i = 0; i<al.size();i++){
            arr[i][0] = al.get(i).get(0);
            arr[i][1] = al.get(i).get(1);
            arr[i][2] = al.get(i).get(2);
            arr[i][3] = al.get(i).get(3);
        }
        return arr;
    }

    public void dfs(int[][] land, int r, int c, ArrayList<ArrayList<Integer>> al) {
        int dx[] = new int[] { 0, 0, -1, 1 };
        int dy[] = new int[] { 1, -1, 0, 0 };
        int minX = r;
        int minY = c;
        int maxX = r;
        int maxY = c;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!isValid(land, newX, newY))
                    continue;
                land[newX][newY] = 0;
                q.add(new Pair(newX, newY));
                minX = Math.min(minX, newX);
                minY = Math.min(minY, newY);
                maxX = Math.max(maxX, newX);
                maxY = Math.max(maxY, newY);
            }
        }
        al.add(new ArrayList<>(Arrays.asList(minX, minY, maxX, maxY)));
    }

    public boolean isValid(int land[][], int r, int c) {
        if (r < 0 || c < 0 || r >= land.length || c >= land[0].length || land[r][c] == 0)
            return false;
        return true;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}