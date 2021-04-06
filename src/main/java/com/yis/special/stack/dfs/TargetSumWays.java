package com.yis.special.stack.dfs;

/**
 * @author YeShuai
 * @date 2021/2/8
 */
public class TargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][13];
        dp[0][nums[0] + 6] = 1;
        dp[0][-nums[0] + 6] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -6; sum <= 6; sum++) {
                if (dp[i - 1][sum + 6] > 0) {
                    dp[i][sum + nums[i] + 6] += dp[i - 1][sum + 6];
                    dp[i][sum - nums[i] + 6] += dp[i - 1][sum + 6];
                }
            }
        }
        return S > 6 ? 0 : dp[nums.length - 1][S + 6];
    }
}
