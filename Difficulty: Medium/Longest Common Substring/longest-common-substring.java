//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maxLen = 0; 

    public int longestCommonSubstr(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        solve(s1, s2, 0, 0, dp);
        return maxLen;
    }

    public int solve(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int count = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            count = 1 + solve(s1, s2, i + 1, j + 1, dp);
            maxLen = Math.max(maxLen, count); // update the max length
        }

        // explore other paths (without continuing the substring)
        solve(s1, s2, i + 1, j, dp);
        solve(s1, s2, i, j + 1, dp);

        return dp[i][j] = count;
    }
}
