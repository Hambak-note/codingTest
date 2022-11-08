package 이진탐색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DoublePriorityQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfInputData = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < numberOfInputData; i++) {
            int numberOfOperations = Integer.parseInt(br.readLine());
            TreeSet<Integer> queue = new TreeSet<>();


            for (int j = 0; j < numberOfOperations; j++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                if (op.equals("D")) {
                    int number = Integer.parseInt(st.nextToken());
                    if(queue.isEmpty()) continue;
                    //최대값 삭제
                    if(number == 1) queue.pollLast();
                    //최소값 삭제
                    else queue.pollFirst();
                }
                else{
                    int number = Integer.parseInt(st.nextToken());
                    queue.add(number);
                }
            }
            if(queue.isEmpty()) System.out.println("EMPTY");
            else{
                System.out.println(queue.last() + " " + queue.first());
            }
        }
    }
}
