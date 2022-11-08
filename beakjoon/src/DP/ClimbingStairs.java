package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {

    static int numberOfStair;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfStair = Integer.parseInt(br.readLine());
        stairs = new int[305];
        for(int i = 1; i <=numberOfStair; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if(numberOfStair == 1){
            System.out.println(stairs[1]);
            return;
        }

        dp = new int[305][3];
        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[1] + stairs[2];

        for(int i = 3; i <= numberOfStair; i++){
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) +  stairs[i];
            dp[i][2] = dp[i-1][1]+stairs[i];
        }

        System.out.println(Math.max(dp[numberOfStair][1], dp[numberOfStair][2]));
    }
}
