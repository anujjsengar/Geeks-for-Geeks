// User function Template for Java

class Solution {
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int[][] dp=new int[s1.length()][s2.length()];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return s1.length()+s2.length()-solve(s1,s2,0,0,dp);
    }
    public static int solve(String text1,String text2,int i,int j,int[][] dp){
        if(text1.length()==i || text2.length()==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count=0;
        if(text1.charAt(i)==text2.charAt(j)){
            count=1+solve(text1,text2,i+1,j+1,dp);
        }
        else{
            count=Math.max(solve(text1,text2,i+1,j,dp),solve(text1,text2,i,j+1,dp));
        }
        return dp[i][j]=count;
    }
}