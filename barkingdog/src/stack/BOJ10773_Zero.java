package stack;

import java.io.*;
import java.util.Stack;

public class BOJ10773_Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        int currentInput = -1;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            currentInput = Integer.parseInt(br.readLine());
            if(currentInput ==0) {
                stack.pop();
                continue;
            }
            stack.push(currentInput);
        }


        for (Integer element : stack) {
            sum += element;
        }

        bw.write(sum + "\n");
        bw.flush();
    }
}
