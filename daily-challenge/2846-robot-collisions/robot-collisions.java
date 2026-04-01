class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        Stack<Robot> st = new Stack<>();

        for (Robot curr : robots) {
            while (!st.isEmpty() && st.peek().direction == 'R' && curr.direction == 'L') {
                if (st.peek().health == curr.health) {
                    st.pop();
                    curr.health = 0;
                    break;
                } else if (st.peek().health < curr.health) {
                    st.pop();
                    curr.health--;
                } else {
                    st.peek().health--;
                    curr.health = 0;
                    break;
                }
            }

            if (curr.health > 0) {
                st.push(curr);
            }
        }

        List<Robot> survivors = new ArrayList<>(st);
        Collections.sort(survivors, (a, b) -> a.idx - b.idx);

        List<Integer> res = new ArrayList<>();
        for (Robot r : survivors) res.add(r.health);

        return res;
    }
}
class Robot {
    int position;
    int health;
    char direction;
    int idx;

    Robot(int p, int h, char d, int i) {
        this.position = p;
        this.health = h;
        this.direction = d;
        this.idx = i;
    }
}