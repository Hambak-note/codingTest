package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindTheSumOfIntervals {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfNumbers = Integer.parseInt(st.nextToken());
        int numberOfTimesToSum = Integer.parseInt(st.nextToken());

        int[] dp = new int[100004];
        int[] numArr = new int[100004];

        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= numberOfNumbers; i++){
            numArr[i] = Integer.parseInt(st.nextToken());

            dp[i] = dp[i-1] + numArr[i];
        }

        while(numberOfTimesToSum != 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(dp[j] - dp[i-1]);
            numberOfTimesToSum--;
        }
    }
}
