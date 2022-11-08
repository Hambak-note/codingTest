package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin_0 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int typeOfCoin = Integer.parseInt(st.nextToken());
        int sumOfValues = Integer.parseInt(st.nextToken());
        int[] coinTypeArr = new int[typeOfCoin];
        int answer = 0;

        for (int i = 0; i < typeOfCoin; i++) {
            coinTypeArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = typeOfCoin - 1; i >= 0; i--) {
            answer += sumOfValues / coinTypeArr[i];
            sumOfValues %= coinTypeArr[i];
        }

        System.out.println(answer);
    }
}
