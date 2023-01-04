package stack;

public class Stack {

    private final int MAX = 1000005;
    private int dat[] = new int[MAX];
    private int pos = 0;

    /**
     *
     * Stack에 Value를 추가하는 함수
     */
    public void push(int value){
        dat[pos++] = value;
    }

    /**
     * 스택의 꼭대기에 위치한 원소를 제거하는 함수
     */

    public void pop(){
        pos--;
    }

    /**
     * 스택의 꼭대기에 위치한 원소의 값을 확인하는 함수
     */
    public int top(){
        return dat[pos - 1];
    }





}
