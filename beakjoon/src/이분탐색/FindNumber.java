package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(target));
        }
    }

    static int binarySearch(int target){
        int start = 0;
        int end = N-1;
        while (start <= end) {
            int mid = (start+end) / 2;
            if(A[mid] < target){
                start = mid+1;
            }else if(A[mid] > target){
                end = mid-1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
