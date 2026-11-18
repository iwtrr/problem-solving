// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zero = str.replaceAll("[^0]", "").length();
            int one = str.replaceAll("[^1]", "").length();

            for (int cm = m; cm >= zero; cm--) {
                for (int cn = n; cn >= one; cn--) {
                    dp[cm][cn] = Math.max(dp[cm - zero][cn - one] + 1, dp[cm][cn]);
                }
            }
        }

        return dp[m][n];
    }
}