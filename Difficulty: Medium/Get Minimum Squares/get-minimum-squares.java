// User function Template for Java

class Solution {
    public int MinSquares(int n) {
        // Code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int dp[]){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int result=solve(n-(i*i),dp);
            if(result!=Integer.MAX_VALUE){
                min=Math.min(min,1+result);
            }
        }
        return dp[n]=min;
    }
}