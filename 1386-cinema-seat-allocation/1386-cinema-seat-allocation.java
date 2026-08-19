class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> reserved = new HashMap<>();

        // Store reserved seats as a bitmask for each affected row
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2..9 matter
            if (col >= 2 && col <= 9) {
                int bit = 1 << (col - 2);
                reserved.put(row, reserved.getOrDefault(row, 0) | bit);
            }
        }

        // Rows with no relevant reserved seats can hold 2 families
        int ans = 2 * (n - reserved.size());

        // Masks for the three possible family positions
        int left  = 0b00001111; // seats 2,3,4,5
        int middle = 0b00111100; // seats 4,5,6,7
        int right = 0b11110000; // seats 6,7,8,9

        for (int mask : reserved.values()) {

            boolean canLeft = (mask & left) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                // Two families: [2-5] and [6-9]
                ans += 2;
            } else if (canLeft || canRight || (mask & middle) == 0) {
                // One family
                ans += 1;
            }
        }

        return ans;
    }
}