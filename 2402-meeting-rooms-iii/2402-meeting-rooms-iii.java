class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];
        long[] end = new long[n];

        for (int[] meeting : meetings) {

            int start = meeting[0];
            int finish = meeting[1];
            int duration = finish - start;

            int room = -1;

            // Find available room
            for (int i = 0; i < n; i++) {
                if (end[i] <= start) {
                    room = i;
                    break;
                }
            }

            // If room available
            if (room != -1) {
                end[room] = finish;
                count[room]++;
            }
            else {

                // Find earliest finishing room
                room = 0;

                for (int i = 1; i < n; i++) {
                    if (end[i] < end[room]) {
                        room = i;
                    }
                }

                // Delay meeting
                end[room] += duration;
                count[room]++;
            }
        }

        // Find room with maximum meetings
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}