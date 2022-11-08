package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance {
    static int numberOfHouse;
    static int[][] dp = new int[1005][3];
    static int[] red = new int[1005];
    static int[] green = new int[1005];
    static int[] blue = new int[1005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfHouse = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 1; i <= numberOfHouse; i++){
            st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = red[1];
        dp[1][1] = green[1];
        dp[1][2] = blue[1];

        for(int i = 2; i <= numberOfHouse; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue[i];
        }

        int result = Math.min(dp[numberOfHouse][0], dp[numberOfHouse][1]);
        result = Math.min(result, dp[numberOfHouse][2]);

        System.out.println(result);
    }
}
