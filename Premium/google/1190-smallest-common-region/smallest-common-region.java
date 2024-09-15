class Solution {

    private List<String> fetchPathForRegion(
            String currNode,
            Map<String, String> childParentMap) {
        List<String> path = new ArrayList<>();
        path.add(currNode);

        while (childParentMap.containsKey(currNode)) {
            String parentNode = childParentMap.get(currNode);
            path.add(parentNode);
            currNode = parentNode;
        }
        Collections.reverse(path);
        return path;
    }

    public String findSmallestRegion(
            List<List<String>> regions,
            String region1,
            String region2) {
        Map<String, String> childParentMap = new HashMap<>();

        for (List<String> regionArray : regions) {
            String parentNode = regionArray.get(0);
            for (int i = 1; i < regionArray.size(); i++) {
                childParentMap.put(regionArray.get(i), parentNode);
            }
        }

        List<String> path1 = fetchPathForRegion(region1, childParentMap);
        List<String> path2 = fetchPathForRegion(region2, childParentMap);

        int i = 0, j = 0;
        String lowestCommonAncestor = "";
        while (i < path1.size() &&
                j < path2.size() &&
                path1.get(i).equals(path2.get(j))) {
            lowestCommonAncestor = path1.get(i);
            i++;
            j++;
        }

        return lowestCommonAncestor;
    }
}