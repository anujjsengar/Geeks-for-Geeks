// User function Template for Java
class Solution {
    public int maximumPath(int[][] mat) {
        // code here
        int[][] dp=new int[mat.length][mat[0].length];
        int max=0;
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int j=0;j<mat[0].length;j++){
            max=Math.max(max,solve(mat,0,j,dp));
        }
        return max;
    }
    public int solve(int[][] mat,int i,int j,int[][] dp){
        if(i==mat.length){
            return 0;
        }
        if(j<0 || j>=mat[0].length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=mat[i][j]+Math.max(solve(mat,i+1,j-1,dp),Math.max(solve(mat,i+1,j,dp),solve(mat,i+1,j+1,dp)));
    }
}