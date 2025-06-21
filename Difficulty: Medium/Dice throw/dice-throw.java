class Solution {
    static int noOfWays(int m, int n, int x) {
        // code here
        int dp[][]=new int[n+1][x+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solve(m,n,x,dp);
    }
    static int solve(int m,int n,int x,int dp[][]){
        if(x==0 && n==0){
            return 1;
        }
        if(n<0 || x<0){
            return 0;
        }
        if(dp[n][x]!=-1){
            return dp[n][x];
        }
        int count=0;
        for(int i=1;i<=m;i++){
            count+=solve(m,n-1,x-i,dp);
        }
        return dp[n][x]=count;
    }
};