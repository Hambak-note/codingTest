package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021_SpinningQueue {

    private static LinkedList<Integer> queue;
    private static  int[] extractNumberArr;
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sizeOfQueue = Integer.parseInt(st.nextToken());
        int extractNumberCount = Integer.parseInt(st.nextToken());

        count = 0;

        queue = new LinkedList<>();

        for (int i = 1; i <= sizeOfQueue; i++) {
            queue.offer(i);
        }

        extractNumberArr = new int[extractNumberCount];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < extractNumberCount; i++) {
            extractNumberArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < extractNumberCount; i++) {

            //덱에서 뽑고자 하는 숫자의 위치 찾기
            int targetIdx = queue.indexOf(extractNumberArr[i]);
            int middleIdx;

            /**
             * 큐의 원소가 짝수개라면 중간 지점을 절반 크기에서 -1 감소시킨다.
             */

            if (queue.size() % 2 == 0) {
                middleIdx = queue.size()/2 - 1;
            }
            else{
                middleIdx = queue.size()/2;
            }

            //중간지점 또는 중간지점보다 원소의 위치가 앞에 있는 경우
            if (targetIdx <= middleIdx) {
                //target보다 앞에 있는 원소를 모두 뒤로 보낸다.
                operationNumberTwo(targetIdx);
            } else{
                //중간지점 보다 원소가 뒤에 있는 경우
                operationNumberThree(targetIdx);
            }

            queue.pollFirst();
        }

        System.out.println(count);

    }

    private static void operationNumberTwo(int targetIdx){
        for (int i = 0; i < targetIdx; i++) {
            int temp = queue.pollFirst();
            queue.offerLast(temp);
            count++;
        }
    }

    private static void operationNumberThree(int targetIdx){
        //targetIdx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다.
        //맨 앞에서 값을 꺼내기 위해서 통일하기 위함
        for (int i = 0; i < queue.size()-targetIdx; i++) {
            int temp = queue.pollLast();
            queue.offerFirst(temp);
            count++;
        }
    }


}
