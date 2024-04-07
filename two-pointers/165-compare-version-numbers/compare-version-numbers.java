class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            int temp1 = 0;
            while (i < version1.length() && version1.charAt(i) != '.')
                temp1 = temp1 * 10 + version1.charAt(i++) - '0';
            int temp2 = 0;
            while (j < version2.length() && version2.charAt(j) != '.')
                temp2 = temp2 * 10 + version2.charAt(j++) - '0';
            if (temp1 < temp2)
                return -1;
            if (temp1 > temp2)
                return 1;
            i++;
            j++;
        }
        return 0;
    }
}