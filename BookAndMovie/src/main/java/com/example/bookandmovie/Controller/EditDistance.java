package com.example.bookandmovie.Controller;

public class EditDistance {
    public int solve(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 有一个字符串为空
        if (len1 == 0 || len2 == 0) {
            return len1 + len2;
        }
        // DP数组
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 边界状态初始化
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        // 计算所有DP值
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]);
                }
            }
        }

        return dp[len1][len2];
    }
}
