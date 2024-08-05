class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(arr[i]) == 1)
                al.add(arr[i]);
        }
        if (al.size() < k)
            return "";
        return al.get(k - 1);
    }
}