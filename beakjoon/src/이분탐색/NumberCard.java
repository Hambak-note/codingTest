package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {

    static int[] cardArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCard = Integer.parseInt(br.readLine());

        cardArr = new int[numberOfCard];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberOfCard; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cardArr);

        int numberOfTarget = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfTarget; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upper_idx(target, numberOfCard) - lower_idx(target, numberOfCard)).append(' ');
        }
        System.out.println(sb);
    }

    static int lower_idx(int target, int len){
        int st = 0;
        int en = len;
        while(st < en){
            int mid = (st+en) / 2;
            if(cardArr[mid] >= target){
                en = mid;
            }else{
                st = mid+1;
            }
        }
        return st;
    }

    static int upper_idx(int target, int len){
        int st = 0;
        int en = len;
        while(st < en){
            int mid = (st+en) / 2;
            if(cardArr[mid] > target){
                en = mid;
            }else{
                st = mid+1;
            }
        }
        return st;
    }
}
