package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weightPerRope = new int[N];

        for (int i = 0; i < N; i++) {
            weightPerRope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weightPerRope);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, weightPerRope[N - i] * i);
        }

        System.out.println(answer);
    }
}
