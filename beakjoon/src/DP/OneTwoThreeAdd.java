package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dpArr = new int[12];
        dpArr[1] = 1;
        dpArr[2] = 2;
        dpArr[3] = 4;

        for(int i = 4; i <= 11; i++){
            dpArr[i] = dpArr[i - 1] + dpArr[i - 2] + dpArr[i - 3];
        }

        int NumberOfTestCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < NumberOfTestCase; i++){
            int testCase = Integer.parseInt(br.readLine());
            System.out.println(dpArr[testCase]);
        }
    }
}
