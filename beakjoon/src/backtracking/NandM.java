package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM {
    static int N;
    static int M;
    static int[] sequenceArr;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequenceArr = new int[N];
        isUsed = new boolean[N+1];

        Solution(0);

    }

    public static void Solution(int count){
        if(count == M){
            for(int i = 0; i < M; i++){
                System.out.print(sequenceArr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!isUsed[i]){
                sequenceArr[count] = i;
                isUsed[i] = true;
                Solution(count+1);
                isUsed[i] = false;
            }
        }

    }

}
