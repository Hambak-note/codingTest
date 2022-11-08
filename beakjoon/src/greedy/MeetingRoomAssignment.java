package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MeetingRoomAssignment {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfMeetings = Integer.parseInt(br.readLine());

        int[][] informationFromTheMeeting = new int[numberOfMeetings][2];
        StringTokenizer st;
        for(int i = 0; i<numberOfMeetings; i++){
            st = new StringTokenizer(br.readLine());
            informationFromTheMeeting[i][1] = Integer.parseInt(st.nextToken());
            informationFromTheMeeting[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(informationFromTheMeeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });



        int answer = 0;
        int currentTime = 0;

        for(int i = 0; i < numberOfMeetings; i++){
            if(currentTime > informationFromTheMeeting[i][1]) continue;
            answer++;
            currentTime = informationFromTheMeeting[i][0];
        }

        System.out.println(answer);
    }


}
