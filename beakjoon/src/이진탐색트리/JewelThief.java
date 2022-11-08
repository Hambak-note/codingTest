package 이진탐색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class JewelThief {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberOfJewels = Integer.parseInt(st.nextToken());
        int numberOfBags = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[numberOfJewels][2];
        TreeSet<Integer> bag = new TreeSet<>();

        //정렬의 편의를 위해 가격을 인덱스 [i][0]에 담는다.
        for(int i = 0; i < numberOfJewels; i++){
            st = new StringTokenizer(br.readLine());
            jewel[i][1] = Integer.parseInt(st.nextToken());
            jewel[i][0] = Integer.parseInt(st.nextToken());
        }


        //정렬
        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        for(int i = 0; i < numberOfBags; i++){
            bag.add(Integer.valueOf(br.readLine()));
        }

        long answer = 0;

        for(int i = numberOfJewels-1; i >= 0; i--){
            int jewelWeight = jewel[i][1];
            Integer bagWeight = bag.ceiling(jewelWeight);
            if(bagWeight == null) continue;
            answer += jewel[i][0];
            bag.remove(bagWeight);
        }

        System.out.println(answer);
    }
}
