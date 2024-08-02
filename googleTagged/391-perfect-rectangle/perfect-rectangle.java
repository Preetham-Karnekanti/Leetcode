class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }

        // Use a set to track unique corners
        Set<String> corners = new HashSet<>();
        int area = 0;

        // Boundaries of the overall rectangle
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] rect : rectangles) {
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            // Update the boundaries of the overall rectangle
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Calculate the area covered by the current rectangle
            area += (x2 - x1) * (y2 - y1);

            // Define the corners of the current rectangle
            String[] currentCorners = {
                x1 + " " + y1, 
                x1 + " " + y2, 
                x2 + " " + y1, 
                x2 + " " + y2
            };

            // Track corners and their occurrences
            for (String corner : currentCorners) {
                if (!corners.add(corner)) {
                    corners.remove(corner);
                }
            }
        }

        // The area of the overall rectangle
        int boundingArea = (maxX - minX) * (maxY - minY);

        // Check if the total area matches the bounding rectangle area
        if (area != boundingArea) {
            return false;
        }

        // Check if we have exactly 4 corners left
        if (corners.size() != 4 || 
            !corners.contains(minX + " " + minY) ||
            !corners.contains(minX + " " + maxY) ||
            !corners.contains(maxX + " " + minY) ||
            !corners.contains(maxX + " " + maxY)) {
            return false;
        }

        return true;
    }
}