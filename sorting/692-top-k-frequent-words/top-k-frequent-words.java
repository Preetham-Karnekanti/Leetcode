class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], hm.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.value == b.value)
                return a.str.compareTo(b.str);
            return b.value - a.value;
        });
        for (String s : hm.keySet()) {
            pq.add(new Pair(s, hm.get(s)));
        }
        List<String> al = new ArrayList<>();
        while (k-- > 0) {
            al.add(pq.poll().str);
        }

        return al;
    }
}

class Pair {
    String str;
    int value;

    Pair(String str, int value) {
        this.str = str;
        this.value = value;
    }

    public String toString() {
        return str + " " + value;
    }
}