class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int [][] dp=new int[grid.length][grid[0].length];
        for(int [] d:dp){
            Arrays.fill(d,-1);
        }
        return path(grid,0,0,dp);
    }
    public int path(int[][] grid,int i,int j,int[][] dp){
        if(i>=grid.length || j>=grid[0].length || grid[i][j]==1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }        //grid[i][j]=1;
        return dp[i][j]=path(grid,i+1,j,dp) + path(grid,i,j+1,dp);
    }
};