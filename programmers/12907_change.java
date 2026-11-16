// https://school.programmers.co.kr/learn/courses/30/lessons/12907

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = money.length - 1; i >= 0; i--) {
            for (int rest = money[i]; rest <= n; ++rest) {
                dp[rest] = (dp[rest] + dp[rest - money[i]]) % 1_000_000_007;
            }
        }

        return dp[n];
    }
}