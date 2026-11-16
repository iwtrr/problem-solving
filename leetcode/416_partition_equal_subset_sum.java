// https://leetcode.com/problems/partition-equal-subset-sum

import java.util.stream.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int total = IntStream.of(nums).sum();

        if (total % 2 == 1) {
            return false;
        }

        boolean[] dp = new boolean[total / 2 + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = total / 2; i >= num; --i) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[total / 2];
    }
}