package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeItOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int[] dpArr = new int[1000005];

        dpArr[1] = 0;
        for(int i = 2; i <= X; i++){
            dpArr[i] = dpArr[i-1]+1;
            if (i % 2 == 0) {
                dpArr[i] = Math.min(dpArr[i], dpArr[i/2]+1);
            }
            if (i % 3 == 0) {
                dpArr[i] = Math.min(dpArr[i], dpArr[i/3]+1);
            }
        }
        System.out.println(dpArr[X]);
    }
}
