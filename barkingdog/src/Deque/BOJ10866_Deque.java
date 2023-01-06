package Deque;

import java.io.*;

public class BOJ10866_Deque {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int commandCount = Integer.parseInt(br.readLine());

        IntDeque intDeque = new IntDeque();

        for (int i = 0; i < commandCount; i++) {
            String[] command = br.readLine().split(" ");

            if(command[0].equals("push_back")){
                intDeque.push_back(Integer.parseInt(command[1]));
                continue;
            }
            if(command[0].equals("push_front")){
                intDeque.push_front(Integer.parseInt(command[1]));
                continue;
            }
            if(command[0].equals("pop_front")){
                bw.write(intDeque.pop_front()+"\n");
                continue;
            }
            if(command[0].equals("pop_back")){
                bw.write(intDeque.pop_back()+"\n");
                continue;
            }
            if(command[0].equals("front")){
               bw.write(intDeque.front()+"\n");
                continue;
            }
            if(command[0].equals("back")){
                bw.write(intDeque.back()+"\n");
                continue;
            }
            if(command[0].equals("size")){
                bw.write(intDeque.size()+"\n");
                continue;
            }
            bw.write(intDeque.empty()+"\n");
        }

        bw.flush();
    }
}

class IntDeque{
    private final int MX = 1000005;
    private int[] dat = new int[2*MX+1];
    private int head = MX;
    private int tail = MX;

    public void push_front(int x){
        dat[--head] = x;
    }

    public void push_back(int x){
        dat[tail++] = x;
    }

    public int pop_front(){
        if(empty()==1) return -1;
        return dat[head++];
    }

    public int pop_back(){
        int result = back();
        if(result==-1) return result;
        tail--;
        return result;
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
        return tail - head;
    }

    public int empty(){
        if(head==tail) return 1;
        return 0;
    }
}
