class Solution {
   public int findJudge(int n, int[][] trust) {
    if (n == 1) {
        return 1; // If there's only one person, they are trivially the judge.
    }

    int[] inDegree = new int[n + 1]; // To count the number of people trusting each person
    int[] outDegree = new int[n + 1]; // To count the number of people each person trusts

    // Populate inDegree and outDegree arrays
    for (int[] t : trust) {
        int a = t[0]; // Person a
        int b = t[1]; // Person b (who is trusted by a)
        outDegree[a]++; // a trusts someone
        inDegree[b]++;  // b is trusted by someone
    }

    // Find the judge
    for (int i = 1; i <= n; i++) {
        if (inDegree[i] == n - 1 && outDegree[i] == 0) {
            return i; // Person i is the judge
        }
    }

    return -1; // No judge found
}

}