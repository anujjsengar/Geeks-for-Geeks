//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static int lcs(String s1, String s2) {
        int dp[][]=new int[s1.length()][s2.length()];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(s1, s2, 0, 0,dp);
    }

    public static int solve(String s1, String s2, int i, int j,int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count=0;
        if (s1.charAt(i) == s2.charAt(j)) {
            count=1+solve(s1, s2, i + 1, j + 1,dp);
        }
        else{
            int skipS1 = solve(s1, s2, i + 1, j,dp);
            int skipS2 = solve(s1, s2, i, j + 1,dp); 
            count=Math.max(skipS1,skipS2);
        }
        return dp[i][j]=count;
    }
}
