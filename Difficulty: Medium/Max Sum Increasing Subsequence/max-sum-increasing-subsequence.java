
class Solution {
    public int maxSumIS(int arr[]) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int max = dp[0]; // Fix: initialize from dp[0]
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
