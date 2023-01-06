package Deque;

public class MiniDeque {

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

    public void pop_front(){
        head++;
    }

    public void pop_back(){
        tail--;
    }

    public int front(){
        return dat[head];
    }

    public int back(){
        return dat[tail - 1];
    }
}
