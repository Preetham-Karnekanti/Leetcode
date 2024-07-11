class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankGenes = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (String str : bank)
            bankGenes.add(str);
        if (!bankGenes.contains(endGene))
            return -1;
        int steps = 0;
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        visited.add(startGene);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                char[] chArray = cur.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char original = chArray[i];
                    for (char ch = 'A'; ch <= 'Z'; ch++) {
                        if (ch != original) {
                            chArray[i] = ch;
                            String newGene = new String(chArray);
                            if (newGene.equals(endGene))
                                return steps + 1;
                            if (bankGenes.contains(newGene) && !visited.contains(newGene))
                                q.add(newGene);
                                visited.add(newGene);
                        }
                    }
                    chArray[i] = original;
                }
            }
            steps++;
        }
        return -1;
    }
}