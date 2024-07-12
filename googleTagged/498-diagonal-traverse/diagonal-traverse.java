class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int total = m + n - 2;
        for (int i = 0; i <= total; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = i + j;
                al.get(sum).add(mat[i][j]);
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= total; i++) {
            ArrayList<Integer> list = al.get(i);
            if (i % 2 == 0)
                Collections.reverse(list);
            temp.addAll(list);
        }
        int ar[] = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++)
            ar[i] = temp.get(i);
        return ar;
    }
}