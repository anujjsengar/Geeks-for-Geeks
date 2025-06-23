// User function Template for Java

class Solution {
    public int minOperation(int n) {
        // code here.
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int max=Integer.MAX_VALUE;
        if(n%2==0){
            return dp[n]=1+solve(n/2,dp);
        }
        else{
            return dp[n]=1+solve(n-1,dp);
        }
    }
}