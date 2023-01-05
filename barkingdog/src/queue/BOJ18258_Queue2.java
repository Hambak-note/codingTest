package queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ18258_Queue2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();

        //명령의 수 입력
        int commandCount = Integer.parseInt(br.readLine());

        //명령의 수 만큼 반복
        for(int i = 0; i < commandCount; i++){
            String[] currentComment = br.readLine().split(" ");

            if (currentComment[0].equals("push")) {
                deque.addFirst(Integer.valueOf(currentComment[1]));
                continue;
            }
            if (currentComment[0].equals("pop")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.removeLast()+"\n");
                continue;
            }
            if (currentComment[0].equals("size")) {
                bw.write(deque.size()+"\n");
                continue;
            }
            if (currentComment[0].equals("empty")) {
                if(deque.isEmpty()){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
                continue;
            }
            if (currentComment[0].equals("front")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekLast()+"\n");
            }
            if (currentComment[0].equals("back")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.peekFirst()+"\n");
            }
        }

        bw.flush();
        bw.close();

    }


}
