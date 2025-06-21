class Solution {
    public int cutRod(int[] price) {
        int dp[][]=new int[price.length][price.length+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(price,0,price.length,dp);
    }
    public int solve(int[] prices,int i,int left,int[][] dp){
        if(i==prices.length-1 && left==0){
            return 0;
        }
        if(i>=prices.length ||left<0){
            return Integer.MIN_VALUE;
        }
        if(dp[i][left]!=-1){
            return dp[i][left];
        }
        return dp[i][left]=Math.max(prices[i]+solve(prices,i,left-(i+1),dp),solve(prices,i+1,left,dp));
    }
}