import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int required = target.size();
        int formed = 0;

        int left = 0;
        int bestStart = -1;
        int bestLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char added = s.charAt(right);

            // Only track characters required by t.
            Integer needed = target.get(added);
            if (needed != null) {
                int newCount = window.getOrDefault(added, 0) + 1;
                window.put(added, newCount);

                // This character has just reached its required count.
                if (newCount == needed.intValue()) {
                    formed++;
                }
            }

            // Shrink while the window still contains everything required.
            while (formed == required) {
                int length = right - left + 1;

                if (length < bestLength) {
                    bestLength = length;
                    bestStart = left;
                }

                // No valid window can be shorter than t.
                if (bestLength == t.length()) {
                    return s.substring(bestStart, bestStart + bestLength);
                }

                char removed = s.charAt(left);
                Integer neededForRemoved = target.get(removed);

                if (neededForRemoved != null) {
                    int oldCount = window.get(removed);

                    // Removing this character will make its count too small.
                    if (oldCount == neededForRemoved.intValue()) {
                        formed--;
                    }

                    window.put(removed, oldCount - 1);
                }

                left++;
            }
        }

        return bestStart == -1
                ? ""
                : s.substring(bestStart, bestStart + bestLength);
    }
}