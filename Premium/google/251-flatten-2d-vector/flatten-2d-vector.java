class Vector2D {
    ArrayList<Integer> al;
    int pointer;

    public Vector2D(int[][] vec) {
        initialise(vec);
    }

    public void initialise(int[][] vec) {
        pointer = 0;
        al = new ArrayList<>();
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[i].length; j++) {
                al.add(vec[i][j]);
            }
        }
    }

    public int next() {
        return al.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < al.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */