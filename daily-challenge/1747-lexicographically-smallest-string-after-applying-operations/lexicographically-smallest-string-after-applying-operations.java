class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        String ans = s;
        q.add(s);
        HashSet<String> hs = new HashSet<>();
        hs.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            String s1 = addA(cur, a);
            String s2 = rotate(cur, b);
            if (!hs.contains(s1)) {
                if (ans.compareTo(s1) > 0)
                    ans = s1;
                hs.add(s1);
                q.add(s1);
            }
            if (!hs.contains(s2)) {
                if (ans.compareTo(s2) > 0)
                    ans = s2;
                hs.add(s2);
                q.add(s2);
            }
        }
        return ans;
    }

    public String addA(String s, int a) {
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 1) {
                int num = ch[i] - 48;
                num += a;
                num = num % 10;
                ch[i] = (char) (num + 48);
            }
        }
        return new String(ch);
    }

    public String rotate(String s, int b) {
        return s.substring(b) + s.substring(0, b);
    }
}