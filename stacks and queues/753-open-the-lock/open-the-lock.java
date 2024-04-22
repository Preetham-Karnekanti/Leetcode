class Solution {
    HashSet<String> hs;

    public int openLock(String[] deadends, String target) {
        hs = new HashSet<>();
        for (String s : deadends) {
            hs.add(s);
            if (s.equals("0000"))
                return -1;
        }

        return bfs(target);
    }

    public int bfs(String target) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        q.add(new Pair("0000", 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String key = p.password;
            int moves = p.moves;

            if (key.equals(target))
                return moves;
            for (int i = 0; i < 4; i++) {
                char prev = getPrev(key.charAt(i));
                char next = getNext(key.charAt(i));
                String nextCom = key.substring(0, i) + next + key.substring(i + 1);
                String prevCom = key.substring(0, i) + prev + key.substring(i + 1);
                if (!visited.contains(nextCom) && !hs.contains(nextCom)) {
                    visited.add(nextCom);
                    q.add(new Pair(nextCom, moves + 1));
                }
                if (!visited.contains(prevCom) && !hs.contains(prevCom)) {
                    visited.add(prevCom);
                    q.add(new Pair(prevCom, moves + 1));
                }
            }
        }
        return -1;
    }

    public char getPrev(char ch) {
        int num = (int) ch - '0';
        num--;
        if (num < 0)
            return '9';
        return (char) (num + '0');
    }

    public char getNext(char ch) {
        int num = (int) ch - '0';
        num++;
        if (num > 9)
            return '0';
        return (char) (num + '0');
    }
}

class Pair {
    String password;
    int moves;

    Pair(String password, int moves){
        this.moves = moves;
        this.password = password;
    }
}