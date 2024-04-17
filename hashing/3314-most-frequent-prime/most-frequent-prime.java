class Solution {
    HashMap<Integer, Integer> hm;

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dx[] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int dy[] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
        hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                populateEast(i, j, mat);
                populateSouthEast(i, j, mat);
                populateSouth(i, j, mat);
                populateSouthWest(i, j, mat);
                populateWest(i, j, mat);
                populateNorthWest(i, j, mat);
                populateNorth(i, j, mat);
                populateNorthEast(i, j, mat);
            }
        }
        System.out.println(hm);
        if (hm.size() == 0)
            return -1;
        int maxFreq = 0;
        int max = 0;
        for (int key : hm.keySet()) {
            int val = hm.get(key);
            if (val >= maxFreq) {
                if (val == maxFreq) {
                    max = Math.max(key, max);
                } else
                    max = key;
                maxFreq = val;
            }
        }
        return max;
    }

    public void populateEast(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (j < n) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            j++;
        }
    }

    public void populateSouthEast(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i < m && j < n) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            j++;
            i++;
        }
    }

    public void populateSouth(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i < m) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            i++;
        }
    }

    public void populateSouthWest(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i < m && j >= 0) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            i++;
            j--;
        }
    }

    public void populateWest(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (j >= 0) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            j--;
        }
    }

    public void populateNorthWest(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i >= 0 && j >= 0) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            j--;
            i--;
        }
    }

    public void populateNorth(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i >= 0) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            i--;
        }
    }

    public void populateNorthEast(int i, int j, int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        int num = 0;
        while (i >= 0 && j < n) {
            num = num * 10 + mat[i][j];
            if (isPrime(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
            i--;
            j++;
        }
    }

    public boolean isPrime(int num) {
        if (num <= 10)
            return false;
        if (num == 1)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}