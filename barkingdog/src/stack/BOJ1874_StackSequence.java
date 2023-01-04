package stack;

import java.io.*;
import java.util.Stack;

public class BOJ1874_StackSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //출력 결과 저장

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int stackPushValue = 0;

        while (n-- > 0) {

            int inputValue = Integer.parseInt(br.readLine());

            if(inputValue > stackPushValue){

                for(int i = stackPushValue + 1; i <= inputValue; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                stackPushValue = inputValue;
            }
            //inputValue <= stackPushValue
            if(stack.peek() != inputValue){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
