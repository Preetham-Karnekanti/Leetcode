/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 * // Return the width of char ch when fontSize is used.
 * public int getWidth(int fontSize, char ch) {}
 * // Return Height of any char when fontSize is used.
 * public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int low = 0;
        int high = fonts.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(text, fonts[mid], w, h, fontInfo)) {
                ans = fonts[mid];
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    public boolean isPossible(String text, int fontSize, int w, int h, FontInfo fontInfo) {
        int widthSoFar = 0;
        for (int i = 0; i < text.length(); i++) {
            widthSoFar += fontInfo.getWidth(fontSize, text.charAt(i));
            if (widthSoFar > w)
                return false;
            if (fontInfo.getHeight(fontSize) > h)
                return false;
        }
        return true;
    }
}