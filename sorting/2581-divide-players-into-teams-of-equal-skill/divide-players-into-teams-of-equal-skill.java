class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0;
        for (int i : skill)
            sum += i;
        int n = skill.length / 2;
        sum = sum / n;
        int i = 0;
        int j = skill.length - 1;
        long ans = 0;
        while (i < j) {
            if (sum != skill[i] + skill[j])
                return -1;
            ans += skill[i] * skill[j];
            i++;
            j--;
        }
        return ans;
    }
}