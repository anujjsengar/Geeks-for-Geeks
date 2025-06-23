class Solution {
    public int editDistance(String s1, String s2) {
        int dp[][]=new int [s1.length()][s2.length()];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(s1, s2, 0, 0,dp);
    }

    public int solve(String s1, String s2, int i, int j,int dp[][]) {
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return solve(s1, s2, i + 1, j + 1,dp);
        }

        int insertOp = solve(s1, s2, i, j + 1,dp);
        int deleteOp = solve(s1, s2, i + 1, j,dp);
        int replaceOp = solve(s1, s2, i + 1, j + 1,dp);

        return dp[i][j]= 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
    }
}
