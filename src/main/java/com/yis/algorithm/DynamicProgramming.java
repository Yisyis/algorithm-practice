package com.yis.algorithm;

import java.util.*;

import static java.lang.Math.*;

/**
 * 动态规划
 *
 * @author YeShuai
 * @date 2020/12/21
 */
public class DynamicProgramming {

    /**
     * 暴力递归
     * 斐波拉切数列
     * 存在 ： 重叠子问题
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 带备忘录的递归解法
     *
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N < 0) {
            return 0;
        }
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    private int helper(int[] memo, int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        if (memo[N] != 0) {
            return memo[N];
        }
        memo[N] = helper(memo, N - 1) + helper(memo, N - 2);
        return memo[N];
    }

    /**
     * 数组的迭代解法
     *
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i + 1];
        }
        return dp[N];
    }

    public int fib4(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i < N + 1; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }


    /**
     * 暴力递归
     *
     * @param amount
     * @param coins
     * @return
     */
    public static int coinChange(int amount, List<Integer> coins) {  // 11  1,2,5
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int res = amount;
        for (int coin : coins) {
            int subProblem = coinChange(amount - coin, coins);
            if (subProblem == -1) {
                continue;
            }
            res = min(res, 1 + subProblem);
        }
        return res != amount ? res : -1;
    }

    public static int coinChange1(int amount, List<Integer> coins, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int res = amount;
        for (int coin : coins) {
            int subProblem = coinChange1(amount - coin, coins, memo);
            if (subProblem == -1) {
                continue;
            }
            res = min(res, 1 + subProblem);
        }
        memo.put(amount, res <= amount ? res : -1);
        return memo.get(amount);
    }

    public static int coinChange2(int amount, List<Integer> coins) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(5);
        // Map<Integer, Integer> map = new HashMap<>();
        // int i = coinChange2(11, list);
        // int i = coinChange(11, list);
        // int i = coinChange1(6, list, map);
        // System.out.println(i);
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        int i = dynamicProgramming.superEggDrop(4, 5000);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = right + (left - right) / 2;
            if (nums[mid] < target) {
                left = mid - 1;
            } else if (nums[mid] > target) {
                right = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int superEggDrop(int K, int N) {
        Map map = new HashMap();
        int dp = dp(K, N, map);
        return dp;
    }

    public int dp(int k, int n, Map map) {
        if (k == 1) {
            return n;
        }
        if (n == 0 ) {
            return 0;
        }
        if (map.containsKey(k + "_" + n)) {
            return (int)map.get(k + "_" + n);
        }
        int res = n;
        // for (int i = 1; i < n + 1; i++) {
        //     res = min(res, max(dp(k - 1, i - 1, map), dp(k, n - i, map)) + 1);
        // }
        int low = 1;
        int high = n;
        int mid;
        int broke;
        int notBroke;
        while (low <= high) {
            mid = (low + high) / 2;
            broke = dp(k-1, mid-1, map);
            notBroke = dp(k, n - mid, map);
            if (broke > notBroke) {
                high = mid - 1;
                res = min(res, broke + 1);
            } else {
                low = mid + 1;
                res = min(res, notBroke + 1);
            }
        }
        map.put(k+"_"+n, res);
        return res;
    }


}
