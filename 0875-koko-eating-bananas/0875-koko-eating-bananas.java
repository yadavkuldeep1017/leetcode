class Solution {

    private boolean isPossible(int[] piles, int speed, int h) {
        long hoursNeeded = 0;

        for (int pile : piles) {
            hoursNeeded += (pile + speed - 1) / speed;

            // No need to calculate further
            if (hoursNeeded > h) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, mid, h)) {
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1;  // Speed is too slow
            }
        }

        return low;
    }
}