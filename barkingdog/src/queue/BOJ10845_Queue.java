package queue;

import java.io.*;

public class BOJ10845_Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //명령의 수 입력
        int commandCount = Integer.parseInt(br.readLine());
        CustomQueue customQueue = new CustomQueue();

        //명령의 수 만큼 반복
        for(int i = 0; i < commandCount; i++){
            String[] currentComment = br.readLine().split(" ");

            if (currentComment[0].equals("push")) {
                customQueue.push(Integer.parseInt(currentComment[1]));
                continue;
            }
            if (currentComment[0].equals("pop")) {
                bw.write(customQueue.pop()+"\n");
            }
            if (currentComment[0].equals("size")) {
                bw.write(customQueue.size()+"\n");
            }
            if (currentComment[0].equals("empty")) {
                bw.write(customQueue.empty()+"\n");
            }
            if (currentComment[0].equals("front")) {
                bw.write(customQueue.front()+"\n");
            }
            if (currentComment[0].equals("back")) {
                bw.write(customQueue.back()+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

}

class CustomQueue{
    private final int MX = 1000005;
    private int[] dat = new int[MX];
    private int head = 0;
    private int tail = 0;


    public void push(int x){
        dat[tail++] = x;
    }

    public int pop(){
        if(empty()==1) return -1;
        return dat[head++];
    }

    public int front(){
        if(empty()==1) return -1;
        return dat[head];
    }

    public int back(){
        if(empty()==1) return -1;
        return dat[tail-1];
    }

    public int size(){
        return tail-head;
    }

    public int empty(){
        if(head == tail) return 1;
        return 0;
    }

}
