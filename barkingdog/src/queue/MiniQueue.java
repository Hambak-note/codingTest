package queue;

public class MiniQueue {

    private final int MX = 1000005;
    private int[] dat = new int[MX];
    private int head = 0;
    private int tail = 0;


    public void push(int x){
        dat[tail++] = x;
    }

    public void pop(){
        head++;
    }

    public int front(){
        return dat[head];
    }

    public int back(){
        return dat[tail-1];
    }



}
