class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        for (List<String> t : access_times) {
            String u = t.get(0);
            int time = Integer.parseInt(t.get(1));
            hm.putIfAbsent(u, new ArrayList<>());
            hm.get(u).add(time);
        }
        List<String> answer = new ArrayList<>();
        for (String key : hm.keySet()) {
            if (isAccessible(hm.get(key))) {
                answer.add(key);
            }
        }
        return answer;
    }

    public boolean isAccessible(ArrayList<Integer> times) {
        if (times.size() < 3)
            return false;
        Collections.sort(times);
        for (int i = 2; i < times.size(); i++) {
            if (times.get(i) - times.get(i - 2) < 100)
                return true;
        }
        return false;
    }
}