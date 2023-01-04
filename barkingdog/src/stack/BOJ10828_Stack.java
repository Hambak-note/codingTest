package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10828_Stack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = 0;
        commandCount = Integer.parseInt(br.readLine());
        IntStack intStack = new IntStack();

        for(int i=0; i < commandCount; i++){
            String commandArr[] = br.readLine().split(" ");

            if(commandArr[0].equals("push")){
                intStack.push(Integer.parseInt(commandArr[1]));
                continue;
            }
            if(commandArr[0].equals("pop")){
                System.out.println(intStack.pop());;
                continue;
            }
            if(commandArr[0].equals("size")){
                System.out.println(intStack.size());;
                continue;
            }
            if(commandArr[0].equals("empty")){
                System.out.println(intStack.empty());;
                continue;
            }
            System.out.println(intStack.top());
        }
    }

}

class IntStack{

    private static final int MAX = 10005;
    private int dat[] = new int[MAX];
    private int pos = 0;

    public void push(int value){
        dat[pos++] = value;
    }

    public int pop(){
        if(empty() == 1) return -1;
        pos--;
        return dat[pos];
    }

    public int top(){
        if(empty()==1) return -1;
        return dat[pos - 1];
    }

    public int size(){
        return pos;
    }

    public int empty(){
        if(pos<=0){
            return 1;
        }
        return 0;
    }
}
