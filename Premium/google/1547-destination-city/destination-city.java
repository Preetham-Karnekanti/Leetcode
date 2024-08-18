class Solution {
    public String destCity(List<List<String>> paths) {
        int idx = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (List<String> e : paths) {
            String u = e.get(0);
            String v = e.get(1);
            hm.put(u, 0);
            hm.put(v, 0);
        }
        for (List<String> e : paths) {
            String u = e.get(0);
            String v = e.get(1);
            hm.put(u, hm.get(u) + 1);
        }
        for (String key : hm.keySet()) {
            if (hm.get(key) == 0)
                return key;
        }
        return "";
    }
}