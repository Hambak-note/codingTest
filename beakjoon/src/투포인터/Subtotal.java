package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subtotal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sequenceLength = Integer.parseInt(st.nextToken());
        int subtotal = Integer.parseInt(st.nextToken());

        int[] sequenceArr = new int[sequenceLength];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sequenceLength; i++) {
            sequenceArr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        int sum = sequenceArr[0];
        int shortestLength = Integer.MAX_VALUE;
        for (int start = 0; start < sequenceLength; start++) {
            while(end < sequenceLength && sum < subtotal){
                end++;
                if(end != sequenceLength) sum += sequenceArr[end];
            }
            if(end == sequenceLength) break;
            shortestLength = Math.min(shortestLength, end - start+1);
            sum -= sequenceArr[start];
        }

        if(shortestLength == Integer.MAX_VALUE) shortestLength = 0;

        System.out.println(shortestLength);
    }
}
