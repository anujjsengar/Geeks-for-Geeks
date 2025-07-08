//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
    static int solve(int[] cost,int i,int[] dp){
        if(i==cost.length){
            return 0;
        }
        if(i>cost.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=cost[i] + Math.min(solve(cost,i+1,dp),solve(cost,i+2,dp));
    }
};