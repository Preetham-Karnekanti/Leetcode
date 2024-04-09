class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        HashSet<List<Integer>> hs = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(x);
        temp.add(y);
        hs.add(temp);
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            ArrayList<Integer> al = new ArrayList<>();
            al.add(x);
            al.add(y);
            if (hs.contains(al))
                return true;
            hs.add(al);
        }
        return false;
    }
}