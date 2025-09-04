import java.util.*;

class Solution {
    public int[] minDifference(int n, int k) {
        // reset globals
        int[] result = new int[k];
        List<Integer> factors = new ArrayList<>();
        
        // collect factors
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors);

        // best answer storage
        List<Integer> best = new ArrayList<>();
        int[] minDiff = {Integer.MAX_VALUE};

        dfs(factors, 1, new ArrayList<>(), n, k, best, minDiff);

        // convert best list into result array
        for (int i = 0; i < k; i++) {
            result[i] = best.get(i);
        }
        return result;
    }

    private void dfs(List<Integer> factors, long product, List<Integer> temp, 
                     int n, int k, List<Integer> best, int[] minDiff) {
        if (temp.size() > k || product > n) return;

        if (temp.size() == k) {
            if (product == n) {
                int minVal = Collections.min(temp);
                int maxVal = Collections.max(temp);
                int diff = maxVal - minVal;

                if (diff < minDiff[0]) {
                    minDiff[0] = diff;
                    best.clear();
                    best.addAll(temp);
                }
            }
            return;
        }

        for (int f : factors) {
            long next = product * f;
            if (n % next == 0) {  // pruning
                temp.add(f);
                dfs(factors, product * f, temp, n, k, best, minDiff);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
