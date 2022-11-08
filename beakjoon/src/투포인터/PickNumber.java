package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PickNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int[] nArr = new int[n];
        for(int i = 0; i < n; i++){
            nArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nArr);

        //이중 for문 풀이
//        for(int i = 0; i < n; i++){
//            for(int j = i; j < n; j++){
//                if(nArr[j] - nArr[i] >= m){
//                    min = Math.min(min, nArr[j] - nArr[i]);
//                }
//            }
//        }

        //투포인터 풀이
        int end = 0;
        for (int start = 0; start < n; start++) {
            while(end < n && nArr[end] - nArr[start] < m) end++;
            if(end == n) break;
            min = Math.min(min, nArr[end] - nArr[start]);
        }

        System.out.println(min);
    }
}
